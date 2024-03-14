package com.bootcamp.ejercicio_relaciones.service;

import com.bootcamp.ejercicio_relaciones.dto.ResponseDTO;
import com.bootcamp.ejercicio_relaciones.dto.UserDTO;
import com.bootcamp.ejercicio_relaciones.model.Adress;
import com.bootcamp.ejercicio_relaciones.model.User;
import com.bootcamp.ejercicio_relaciones.repository.IAdressRepository;
import com.bootcamp.ejercicio_relaciones.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {
    private final IUserRepository userRepository;
    private final IAdressRepository adressRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserServiceImp(IUserRepository userRepository, IAdressRepository adressRepository) {
        this.userRepository = userRepository;
        this.adressRepository = adressRepository;
    }
    @Override
    public ResponseDTO save(UserDTO userDTO) {
        //Verificamos que el usuario no exista (vamos a considerar que el DNI es único)
        Optional<User> user = userRepository.findByDni(userDTO.getDni());
        if (user.isPresent()) {
            return new ResponseDTO("User already exists");
        }

        User newUser = new User();
        newUser.setDni(userDTO.getDni());
        newUser.setName(userDTO.getName());
        newUser.setAdress(modelMapper.map(userDTO.getAdress(), Adress.class));
        userRepository.save(newUser);
        return new ResponseDTO("User saved successfully");
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    @Override
    public ResponseDTO delete(String dni) {
        Optional<User> user = userRepository.findByDni(dni);
        if (user.isEmpty()) {
            return new ResponseDTO("User not found");
        }
        userRepository.delete(user.get());
        return new ResponseDTO("User deleted successfully");
    }


}
