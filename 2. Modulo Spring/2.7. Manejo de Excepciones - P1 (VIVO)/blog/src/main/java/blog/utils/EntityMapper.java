package blog.utils;

import blog.dto.EntradaBlogDTO;
import blog.entity.EntradaBlog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EntityMapper {
    public static EntradaBlogDTO entradaBlogMapperDTO(EntradaBlog entradaBlog) {
        return new EntradaBlogDTO(
                entradaBlog.getId(),
                entradaBlog.getTitulo(),
                entradaBlog.getAutor(),
                entradaBlog.getFechaPublicacion().toString());
    }

    public static EntradaBlog entradaBlogMapperEntity(EntradaBlogDTO entradaBlogDTO) {
        return new EntradaBlog(
                entradaBlogDTO.getId(),
                entradaBlogDTO.getTitulo(),
                entradaBlogDTO.getAutor(),
                LocalDate.parse(entradaBlogDTO.getFechaPublicacion(), DateTimeFormatter.ISO_DATE));
    }
}
