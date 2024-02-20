package com.lh.bootjavaspring_profiles_vivo_p2.dto.response;

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
public class LinkDTOGetStats {

    @JsonProperty("id")
    Long id;

    @JsonProperty("url")
    String url;

    @JsonProperty("masked_url")
    String maskedUrl;

    @JsonProperty("redirection_times")
    Long redirectionTimes;

    @JsonProperty("valid")
    Boolean valid;

    @JsonProperty("password")
    String password;
}
