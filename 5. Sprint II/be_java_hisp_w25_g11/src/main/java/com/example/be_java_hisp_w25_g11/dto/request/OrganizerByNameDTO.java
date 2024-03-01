package com.example.be_java_hisp_w25_g11.dto.request;

import com.example.be_java_hisp_w25_g11.dto.commons.enums.EnumNameOrganizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerByNameDTO {
    Integer userId;
    EnumNameOrganizer order;
}
