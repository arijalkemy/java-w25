package com.link.link.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@Data
public class RedirectLinkDTO {
    RedirectView redirectView;
}
