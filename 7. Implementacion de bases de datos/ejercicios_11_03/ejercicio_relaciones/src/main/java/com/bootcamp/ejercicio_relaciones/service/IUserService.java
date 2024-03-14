package com.bootcamp.ejercicio_relaciones.service;

import com.bootcamp.ejercicio_relaciones.dto.ResponseDTO;
import com.bootcamp.ejercicio_relaciones.dto.UserDTO;
import com.bootcamp.ejercicio_relaciones.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    ResponseDTO save(UserDTO userDTO);
    List<UserDTO> getAll();
    ResponseDTO delete(String dni);
}
