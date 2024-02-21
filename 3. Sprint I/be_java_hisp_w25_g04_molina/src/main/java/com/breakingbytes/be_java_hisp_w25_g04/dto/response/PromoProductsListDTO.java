package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoProductsListDTO {
    @JsonProperty("user_id")
    int userId;
    @JsonProperty("user_name")
    String userName;
    List<ResponsePostDTO> posts;
}
