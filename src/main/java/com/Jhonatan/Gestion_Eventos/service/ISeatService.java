package com.Jhonatan.Gestion_Eventos.service;

import com.Jhonatan.Gestion_Eventos.dto.SeatResponseDTO;
import com.Jhonatan.Gestion_Eventos.model.SeatStatus;

import java.util.List;

public interface ISeatService {

    List<SeatResponseDTO> getSeatsAvailability(Long id, SeatStatus status);
    List<SeatResponseDTO> getSeats(Long eventId);
    void seatReservation(Long eventId, String row, int col);

}
