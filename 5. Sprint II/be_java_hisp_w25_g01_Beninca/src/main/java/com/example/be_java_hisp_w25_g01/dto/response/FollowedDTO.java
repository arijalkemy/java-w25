package com.example.be_java_hisp_w25_g01.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FollowedDTO {
    //US 0004
    Integer user_id;
    String user_name;
    List<UserDTO> followed;

}
