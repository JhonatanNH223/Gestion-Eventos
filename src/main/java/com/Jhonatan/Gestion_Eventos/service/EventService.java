package com.Jhonatan.Gestion_Eventos.service;

import com.Jhonatan.Gestion_Eventos.dto.*;
import com.Jhonatan.Gestion_Eventos.exception.ConflictException;
import com.Jhonatan.Gestion_Eventos.exception.NotFoundException;
import com.Jhonatan.Gestion_Eventos.mapper.EventMapper;
import com.Jhonatan.Gestion_Eventos.mapper.SeatMapper;
import com.Jhonatan.Gestion_Eventos.model.Event;
import com.Jhonatan.Gestion_Eventos.model.Seat;
import com.Jhonatan.Gestion_Eventos.model.SeatStatus;
import com.Jhonatan.Gestion_Eventos.repository.EventRepository;
import com.Jhonatan.Gestion_Eventos.repository.SeatRepository;
import com.Jhonatan.Gestion_Eventos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private SeatRepository seatRepo;
    @Autowired
    private EventRepository eventRepo;

    @Override
    public List<EventResponseDTO> getEvents() {
        return eventRepo.findAll().stream().map(EventMapper::toEventResponseDTO).toList();
    }

    @Override
    public EventResponseDTO createEvent(EventCreateDTO eventCreateDTO) {
        if (eventRepo.existsByTitulo(eventCreateDTO.getTitulo())) {throw new ConflictException("Error al crear Evento: El nombre ya existe");}
        if(eventRepo.existsByUbicacionAndFechaHora(eventCreateDTO.getUbicacion(), eventCreateDTO.getFechaHora())){
            throw new ConflictException("Error al crear Evento: Ya existe un evento en esat misma ubicacion, fecha y hora");
        }

        Event event = EventMapper.toEntity(eventCreateDTO);
        generateSeats(event, eventCreateDTO.getFila(), eventCreateDTO.getAsientosPorFila());
        eventRepo.save(event);
        return EventMapper.toEventResponseDTO(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepo.findById(id)
                .orElseThrow( () -> new NotFoundException("Error al eliminar Evento: Evento no encontrado"));

        eventRepo.deleteById(id);
    }

    @Override
    public EventResponseDTO getEvent(Long id) {
        Event event = eventRepo.findById(id).orElseThrow(()-> new NotFoundException("Error al obtener Evento: Evento no encontrado"));
        return EventMapper.toEventResponseDTO(event);
    }

    @Override
    public EventResponseDTO updateEvent(Long id, EventUpdateDTO eventUpdateDTO){
        Event event = eventRepo.findById(id).orElseThrow(()-> new NotFoundException("Error al actualizar Evento: Evento no encontrado"));

        if (!event.getTitulo().equals(eventUpdateDTO.getTitulo())){
            if (eventRepo.existsByTitulo(eventUpdateDTO.getTitulo())) {
                throw new ConflictException("Error al actualizar Evento: El titulo ya existe");
            }
        }

        if (!event.getUbicacion().equals(eventUpdateDTO.getUbicacion()) && event.getFechaHora() != eventUpdateDTO.getFechaHora()) {
            if (eventRepo.existsByUbicacionAndFechaHora(eventUpdateDTO.getUbicacion(), eventUpdateDTO.getFechaHora())) {
                throw new ConflictException("Error al actualizar Evento: ya hay un evento registrado en esta Ubicacion y hora");
            }
        }


        EventMapper.toEventUpdateDTO(event,  eventUpdateDTO);
        return EventMapper.toEventResponseDTO(eventRepo.save(event));
    }


    @Override
    public EventDetailDTO getEventDetail(Long id) {
        Event event = eventRepo.findById(id).orElseThrow(() -> new NotFoundException("Error al obtener Evento: Evento no encontrado"));
        return EventMapper.toEventDetailDTO(event);
    }


    private void generateSeats(Event event, int filas, int asientosPorFila) {
        for (int i = 0; i < filas; i++) {
            String row = String.valueOf((char) ('A' + i));

            for  (int col = 1; col <= asientosPorFila; col++) {
                Seat seat = new Seat();
                seat.setEvent(event);
                seat.setRow(row);
                seat.setCol(col);
                seat.setStatus(SeatStatus.AVAILABLE);

                event.getSeats().add(seat);
            }
        }
    }
}
