package com.Jhonatan.Gestion_Eventos.repository;

import com.Jhonatan.Gestion_Eventos.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
