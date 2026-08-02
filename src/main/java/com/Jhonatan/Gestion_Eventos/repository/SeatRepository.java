package com.Jhonatan.Gestion_Eventos.repository;

import com.Jhonatan.Gestion_Eventos.model.Seat;
import com.Jhonatan.Gestion_Eventos.model.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
        List<Seat> findByEventIdAndStatus(Long id, SeatStatus status);
        List<Seat> findByEventId(Long id);
        Optional<Seat> findSeatByEventIdAndRowAndCol(Long eventId, String row, int col);
}
