package com.Jhonatan.Gestion_Eventos.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EventDetailDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private List<SeatResponseDTO> seats;
}
