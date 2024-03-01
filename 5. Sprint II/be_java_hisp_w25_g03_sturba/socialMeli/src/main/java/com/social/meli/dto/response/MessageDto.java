package com.social.meli.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class MessageDto {
    String message;
}
