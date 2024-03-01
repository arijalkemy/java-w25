package org.bootcamp.javazoo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bootcamp.javazoo.entity.User;

@AllArgsConstructor
@Data
public class UserDto {

    @NotNull(message = "The 'id' cannot be empty.")
    @Positive (message = "The 'id' must be greater than zero")
    private Integer user_id;

    @NotEmpty (message = "The 'name' cannot be empty.")
    @Size(max = 15, message = "The 'name' cannot be more than 15 characters")
    private String user_name;
}
