package com.Jhonatan.Gestion_Eventos.dto;

import com.Jhonatan.Gestion_Eventos.model.Event;
import com.Jhonatan.Gestion_Eventos.model.SeatStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class SeatCreateDTO {

    @NotNull(message = "Deve de indicar el evento asociado a este aseinto")
    private Long eventId;

    @NotNull(message = "Deve de indicar la Fila")
    private String row;

    @NotNull(message = "Deve de indicar la columna")
    private int col;

}
