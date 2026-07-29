package com.Jhonatan.Gestion_Eventos.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EventCreateDTO {
    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotNull(message = "La fecah y la hora es obligatoria")
    @Future(message = "La fecha del evento tiene que ser futura")
    private LocalDateTime fechaHora;

    @NotBlank(message = "")
    private String ubicacion;

    @Min(value = 1, message = "Debe haber al menos una fila")
    private int fila;

    @Min(value = 1, message = "Debe haber al menos una asiento por fila")
    private int asientosPorFila;



}
