package com.bootcamp.be_java_hisp_w25_g14.utils;

import com.bootcamp.be_java_hisp_w25_g14.exceptions.UserIdException;

public class UserValidator {
    public static void validateUserId(Integer userId, String message) {
        if (userId<=0) throw new UserIdException(message +" can't be negative or zero");
    }
}
