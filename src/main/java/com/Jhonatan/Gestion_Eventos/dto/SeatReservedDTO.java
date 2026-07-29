package com.Jhonatan.Gestion_Eventos.dto;

import com.Jhonatan.Gestion_Eventos.model.SeatStatus;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SeatReservedDTO {
    private SeatStatus status;
}
