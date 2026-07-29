package com.Jhonatan.Gestion_Eventos.controller;

import com.Jhonatan.Gestion_Eventos.dto.SeatResponseDTO;
import com.Jhonatan.Gestion_Eventos.model.SeatStatus;
import com.Jhonatan.Gestion_Eventos.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("seat")
@RestController
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/getSeatsAvailability")
    public ResponseEntity<List<SeatResponseDTO>> getSeatsAvailability(@RequestParam Long id, @RequestParam SeatStatus status){
        return ResponseEntity.ok(seatService.getSeatsAvailability(id,status));
    }

    @PostMapping("reservation")
    public ResponseEntity<?> SeatReservation(@RequestParam Long eventId,@RequestParam String row,@RequestParam int col){
        seatService.seatReservation(eventId,row,col);
        return ResponseEntity.ok("SeatReservado");
    }

}

