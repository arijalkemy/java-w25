package org.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDTO {
    private Long id;
    private String title;
    private String author;
    private LocalDate publicationDate;
}
