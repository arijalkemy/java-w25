package com.example.be_java_hisp_w25_g11_grisales.dto.request;

import com.example.be_java_hisp_w25_g11_grisales.dto.commons.enums.EnumDateOrganizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerByDateDTO {
    Integer userId;
    EnumDateOrganizer order;
}
