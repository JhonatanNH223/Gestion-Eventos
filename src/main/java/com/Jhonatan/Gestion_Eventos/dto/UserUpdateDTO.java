package com.Jhonatan.Gestion_Eventos.dto;

import com.Jhonatan.Gestion_Eventos.model.UserRol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserUpdateDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Size(min = 4, max = 15, message = "La contraseña debe tener entre 4 y 15 caracteres")
    private String password;

    @NotNull(message = "El rol es obligatorio")
    private UserRol rol;
}
