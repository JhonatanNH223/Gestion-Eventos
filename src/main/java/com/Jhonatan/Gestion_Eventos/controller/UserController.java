package com.Jhonatan.Gestion_Eventos.controller;

import com.Jhonatan.Gestion_Eventos.dto.UserCreateDTO;
import com.Jhonatan.Gestion_Eventos.dto.UserResponseDTO;
import com.Jhonatan.Gestion_Eventos.dto.UserUpdateDTO;
import com.Jhonatan.Gestion_Eventos.model.User;
import com.Jhonatan.Gestion_Eventos.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(service.createUser(userCreateDTO));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
        return ResponseEntity.ok(service.updateUser(id, userUpdateDTO));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }
    @GetMapping("/getUserByEmail")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.getUserByEmail(email));
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }


}
