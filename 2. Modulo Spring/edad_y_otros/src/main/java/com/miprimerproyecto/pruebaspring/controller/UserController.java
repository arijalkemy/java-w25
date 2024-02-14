package com.miprimerproyecto.pruebaspring.controller;

import com.miprimerproyecto.pruebaspring.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/getAll")

    public List<User> getAllUsers(){
        List<User> users = loadUsers();
        return users;
    }

    private List<User> loadUsers(){
        return List.of(new User("Jose", "Perez" ), new User("Maria", "Gonzalez"));
    }
}
