package main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryBlog {
    private int id;
    private String title;
    private String autor;
    private String date;
}
