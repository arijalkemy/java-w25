package com.example.be_java_hisp_w25_g01.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FollowersCountDTO {
    //US 0002
    Integer user_id;
    String user_name;
    Long followers_count;

}
