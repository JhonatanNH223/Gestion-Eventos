package com.Jhonatan.Gestion_Eventos.dto;

import com.Jhonatan.Gestion_Eventos.model.SeatStatus;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SeatResponseDTO {
    private Long id;
    private Long eventId;
    private String row;
    private int col;
    private SeatStatus status;
}
