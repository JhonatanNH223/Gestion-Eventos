package com.Jhonatan.Gestion_Eventos.service;

import com.Jhonatan.Gestion_Eventos.dto.UserCreateDTO;
import com.Jhonatan.Gestion_Eventos.dto.UserResponseDTO;
import com.Jhonatan.Gestion_Eventos.dto.UserUpdateDTO;
import com.Jhonatan.Gestion_Eventos.model.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {
    List<UserResponseDTO> getUsers();
    UserResponseDTO createUser(UserCreateDTO userCreateDTO);
    UserResponseDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);
    void deleteUser(Long id);

//    UserResponseDTO getUserById(Integer id);
//    UserResponseDTO getUserByEmail(String email);
//    UserResponseDTO getUserByUsername(String username);
//    UserResponseDTO getUserByUsernameAndPassword(String username, String password);

}