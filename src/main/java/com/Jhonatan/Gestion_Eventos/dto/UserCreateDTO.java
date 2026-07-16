package com.Jhonatan.Gestion_Eventos.dto;

import com.Jhonatan.Gestion_Eventos.model.UserRol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserCreateDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato valido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 4, max = 15, message = "La contraseña debe tener entre 4 y 15 caracteres")
    private String password;

    @NotNull(message = "El rol es obligatorio")
    private UserRol rol;
}
