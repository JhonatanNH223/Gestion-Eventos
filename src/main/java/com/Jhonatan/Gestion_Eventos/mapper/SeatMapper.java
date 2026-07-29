package com.Jhonatan.Gestion_Eventos.mapper;

import com.Jhonatan.Gestion_Eventos.dto.SeatReservedDTO;
import com.Jhonatan.Gestion_Eventos.dto.SeatResponseDTO;
import com.Jhonatan.Gestion_Eventos.model.Seat;

public class SeatMapper {

    public static SeatResponseDTO seatResponseDTO(Seat seat) {
        SeatResponseDTO seatResponseDTO = new SeatResponseDTO();
        seatResponseDTO.setId(seat.getId());
        seatResponseDTO.setEventId(seat.getEvent().getId());
        seatResponseDTO.setRow(seat.getRow());
        seatResponseDTO.setCol(seat.getCol());
        seatResponseDTO.setStatus(seat.getStatus());
        return seatResponseDTO;
    }

    public static void toSeatReserved(Seat seat, SeatReservedDTO seatReservedDTO) {
        seat.setStatus(seatReservedDTO.getStatus());
    }

}
