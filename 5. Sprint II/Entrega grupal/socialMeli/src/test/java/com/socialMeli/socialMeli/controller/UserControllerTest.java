package com.socialMeli.socialMeli.controller;

import com.socialMeli.controller.UserController;
import com.socialMeli.dto.response.MessageDto;
import com.socialMeli.entity.User;
import com.socialMeli.exception.NotFoundException;
import com.socialMeli.repository.IUserRepository;
import com.socialMeli.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

}
