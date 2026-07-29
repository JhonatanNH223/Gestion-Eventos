package com.Jhonatan.Gestion_Eventos.repository;

import com.Jhonatan.Gestion_Eventos.model.Event;
import com.Jhonatan.Gestion_Eventos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByTitulo(String email);
    Boolean existsByTitulo(String email);
    Boolean existsByUbicacionAndFechaHora(String ubicacion, LocalDateTime fechaHora);
}
