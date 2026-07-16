package com.Jhonatan.Gestion_Eventos.mapper;

import com.Jhonatan.Gestion_Eventos.dto.UserCreateDTO;
import com.Jhonatan.Gestion_Eventos.dto.UserResponseDTO;
import com.Jhonatan.Gestion_Eventos.dto.UserUpdateDTO;
import com.Jhonatan.Gestion_Eventos.model.User;

public class UserMapper {

    public static UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRol(user.getRol());
        return userResponseDTO;
    }

    public static User toEntity(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setName(userCreateDTO.getName());
        user.setEmail(userCreateDTO.getEmail());
        user.setPassword(userCreateDTO.getPassword());
        user.setRol(userCreateDTO.getRol());
        return user;
    }

    public static void updateEntity(User user, UserUpdateDTO userUpdateDTO) {
        user.setName(userUpdateDTO.getName());
        user.setPassword(userUpdateDTO.getPassword());
        user.setRol(userUpdateDTO.getRol());
    }



}
