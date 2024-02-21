package com.bootcamp.be_java_hisp_w25_g9.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class UserDtoMixIn {
        @JsonProperty("user_id")
        private int userId;
        
        @JsonProperty("user_name")
        private String userName;
    }
