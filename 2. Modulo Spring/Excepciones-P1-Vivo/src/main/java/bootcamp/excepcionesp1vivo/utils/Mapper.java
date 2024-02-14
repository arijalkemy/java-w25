package bootcamp.excepcionesp1vivo.utils;

import bootcamp.excepcionesp1vivo.dto.BlogDTO;
import bootcamp.excepcionesp1vivo.entity.EntradaBlog;

public class Mapper {

    public static EntradaBlog createEntradaBlog(BlogDTO dto, Integer id) {
        return EntradaBlog.builder()
                .id(id)
                .titulo(dto.getTitulo())
                .autor(dto.getAutor())
                .fechaDePublicacion(dto.getFechaDePublicacion())
                .build();
    }

    public static BlogDTO createBlogDTO(EntradaBlog blog) {
        return BlogDTO.builder()
                .titulo(blog.getTitulo())
                .autor(blog.getAutor())
                .fechaDePublicacion(blog.getFechaDePublicacion())
                .build();
    }

}
