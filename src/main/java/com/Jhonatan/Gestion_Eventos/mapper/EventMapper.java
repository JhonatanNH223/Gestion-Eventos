package com.Jhonatan.Gestion_Eventos.mapper;

import com.Jhonatan.Gestion_Eventos.dto.EventCreateDTO;
import com.Jhonatan.Gestion_Eventos.dto.EventDetailDTO;
import com.Jhonatan.Gestion_Eventos.dto.EventResponseDTO;
import com.Jhonatan.Gestion_Eventos.dto.EventUpdateDTO;
import com.Jhonatan.Gestion_Eventos.model.Event;

public class EventMapper {

    public static Event toEntity(EventCreateDTO eventCreateDTO) {
        Event event = new Event();
        event.setTitulo(eventCreateDTO.getTitulo());
        event.setDescripcion(eventCreateDTO.getDescripcion());
        event.setFechaHora(eventCreateDTO.getFechaHora());
        event.setUbicacion(eventCreateDTO.getUbicacion());
        return event;
    }


    public static EventResponseDTO toEventResponseDTO(Event event){
        EventResponseDTO eventResponseDTO = new EventResponseDTO();
        eventResponseDTO.setId(event.getId());
        eventResponseDTO.setTitulo(event.getTitulo());
        eventResponseDTO.setDescripcion(event.getDescripcion());
        eventResponseDTO.setFechaHora(event.getFechaHora());
        eventResponseDTO.setUbicacion(event.getUbicacion());
        eventResponseDTO.setTotalAsientos(event.getSeats().size());
        return eventResponseDTO;
    }

    public static EventDetailDTO toEventDetailDTO(Event event){
        EventDetailDTO eventDetailDTO = new EventDetailDTO();
        eventDetailDTO.setId(event.getId());
        eventDetailDTO.setTitulo(event.getTitulo());
        eventDetailDTO.setDescripcion(event.getDescripcion());
        eventDetailDTO.setFechaHora(event.getFechaHora());
        eventDetailDTO.setUbicacion(event.getUbicacion());
        eventDetailDTO.setSeats(event.getSeats().stream().map(SeatMapper::seatResponseDTO).toList());
        return eventDetailDTO;
    }

    public static void toEventUpdateDTO(Event event, EventUpdateDTO eventUpdateDTO) {
        event.setTitulo(eventUpdateDTO.getTitulo());
        event.setDescripcion(eventUpdateDTO.getDescripcion());
        event.setFechaHora(eventUpdateDTO.getFechaHora());
        event.setUbicacion(eventUpdateDTO.getUbicacion());
    }


}
