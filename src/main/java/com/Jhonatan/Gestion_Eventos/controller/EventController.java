package com.Jhonatan.Gestion_Eventos.controller;

import com.Jhonatan.Gestion_Eventos.dto.*;
import com.Jhonatan.Gestion_Eventos.model.SeatStatus;
import com.Jhonatan.Gestion_Eventos.service.EventService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("event")
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<EventResponseDTO>> getAllEvents(){
        return ResponseEntity.ok(eventService.getEvents());
    }

    @PostMapping("/saveEvent")
    public ResponseEntity<?> saveEvent(@Valid @RequestBody EventCreateDTO eventCreateDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventCreateDTO));
    }

    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @Valid @RequestBody EventUpdateDTO eventUpdateDTO) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventUpdateDTO));
    }

    @PutMapping("/getEvent/{id}")
    public ResponseEntity<?> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Evento eliminado exitosamente");
    }

    @GetMapping("/getEventDetail/{id}")
    public ResponseEntity<EventDetailDTO>  getEventDetail(@PathVariable Long id){
        return ResponseEntity.ok(eventService.getEventDetail(id));
    }

}
