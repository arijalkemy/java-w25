package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestBlogDTO {
    private int id;
    private String title;
    private String autor;
    private String date;
}
