package com.Jhonatan.Gestion_Eventos.dto;

import com.Jhonatan.Gestion_Eventos.model.UserRol;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private UserRol rol;
}



