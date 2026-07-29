package com.Jhonatan.Gestion_Eventos.service;

import com.Jhonatan.Gestion_Eventos.dto.UserCreateDTO;
import com.Jhonatan.Gestion_Eventos.dto.UserResponseDTO;
import com.Jhonatan.Gestion_Eventos.dto.UserUpdateDTO;
import com.Jhonatan.Gestion_Eventos.exception.ConflictException;
import com.Jhonatan.Gestion_Eventos.exception.NotFoundException;
import com.Jhonatan.Gestion_Eventos.mapper.UserMapper;
import com.Jhonatan.Gestion_Eventos.model.User;
import com.Jhonatan.Gestion_Eventos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    public List<UserResponseDTO> getUsers(){
        return repo.findAll().stream().map(UserMapper::toResponseDTO).toList();
    }

    @Override
    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {

        if (userCreateDTO.getEmail().isEmpty() ||  userCreateDTO.getPassword().isEmpty() || userCreateDTO.getName().isEmpty()) {
            throw new ConflictException("Error al crear Usuario: Todos los campos son obligatorios");
        }

        if(repo.existsByEmail(userCreateDTO.getEmail())){
            throw new ConflictException("Error al crear Usuario: El email ya existe");
        }

        User user = UserMapper.toEntity(userCreateDTO);
        User createdUser = repo.save(user);
        return UserMapper.toResponseDTO(createdUser);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User user = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Error al actualizar Usuario: El usuario no existe"));
        UserMapper.updateEntity(user, userUpdateDTO);


        return UserMapper.toResponseDTO(repo.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Error al eliminar Usuario: el usuario no existe"));
        repo.deleteById(id);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Error al buscar el usuario:  El usuario con el id " + id +  " no existe"));
        return UserMapper.toResponseDTO(user);
    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {
        if (email.isEmpty()) {throw new ConflictException("Error al buscar el usuario: el campo esta vacio");}
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Error al buscar el usuario:  El usuario con el Email " + email +" no existe"));
        return UserMapper.toResponseDTO(user);
    }


}
