package com.Jhonatan.Gestion_Eventos.service;

import com.Jhonatan.Gestion_Eventos.dto.SeatReservedDTO;
import com.Jhonatan.Gestion_Eventos.dto.SeatResponseDTO;
import com.Jhonatan.Gestion_Eventos.exception.ConflictException;
import com.Jhonatan.Gestion_Eventos.exception.NotFoundException;
import com.Jhonatan.Gestion_Eventos.mapper.SeatMapper;
import com.Jhonatan.Gestion_Eventos.model.Seat;
import com.Jhonatan.Gestion_Eventos.model.SeatStatus;
import com.Jhonatan.Gestion_Eventos.repository.EventRepository;
import com.Jhonatan.Gestion_Eventos.repository.SeatRepository;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements ISeatService {
    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private SeatRepository seatRepo;

    @Override
    public List<SeatResponseDTO> getSeatsAvailability(Long id, SeatStatus status) {
        if (!eventRepo.existsById(id)){
            throw new NotFoundException("Error al obtener Evento: Evento no encontrado");
        }
        return seatRepo.findByEventIdAndStatus(id, status).stream().map(SeatMapper::seatResponseDTO).toList();
    }

    @Transactional
    @Override
    public void seatReservation(Long eventId, String row, int col) {
        try {
            Seat seat = seatRepo.findSeatByEventIdAndRowAndCol(eventId, row, col)
                    .orElseThrow(()-> new NotFoundException("Error al obtener Evento: Asiento no encontrado"));
            if(seat.getStatus() == SeatStatus.RESERVED){
                throw new ConflictException("Error al reservar asiento: El asiento ya fue reservado");
            }

            seat.setStatus(SeatStatus.RESERVED);
            seatRepo.saveAndFlush(seat);

        }catch (ObjectOptimisticLockingFailureException | OptimisticLockException e){
            throw new ConflictException("Error al reservar asiento: El asiento acaba de ser reservado por otro usuario");

        }

    }
}
