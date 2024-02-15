package com.lh.bootjavaspring_profiles_vivo_p2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {

    Long id;
    String url;
    String maskedUrl;
    Long redirectionTimes;
    Boolean valid;
    String password;
}
