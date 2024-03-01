package com.socialMeli.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
public class MessageDto {
    String message;

    public MessageDto(Object[] detailMessageArguments) {
        this.message = Arrays.toString(detailMessageArguments);
    }
}
