package com.example.bootcampsprint1g6.util.validator;

import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.util.DateFormatter;

import java.time.LocalDate;

public class PostValidator {
    /**
     * Validates a PostRequestDTO object by checking if its date is in the past or equal to the current date.
     * @param request The PostRequestDTO object to be validated.
     * @return true if the date in the PostRequestDTO is in the past or equal to the current date, false otherwise.
     */
    public static boolean validateRequestDTO (PostRequestDTO request){
        return (DateFormatter.parseDateString(request.getDate()).isBefore(LocalDate.now()) ||
                 DateFormatter.parseDateString(request.getDate()).isEqual(LocalDate.now()) );
    }
}
