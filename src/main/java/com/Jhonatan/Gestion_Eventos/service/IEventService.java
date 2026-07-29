package com.Jhonatan.Gestion_Eventos.service;

import com.Jhonatan.Gestion_Eventos.dto.*;
import com.Jhonatan.Gestion_Eventos.model.SeatStatus;

import java.util.List;

public interface IEventService {

    List<EventResponseDTO> getEvents();
    EventResponseDTO createEvent(EventCreateDTO eventCreateDTO);
    void deleteEvent(Long id);
    EventResponseDTO getEvent(Long id);
    EventResponseDTO updateEvent(Long id, EventUpdateDTO eventUpdateDTO);

    EventDetailDTO getEventDetail(Long id);

}
