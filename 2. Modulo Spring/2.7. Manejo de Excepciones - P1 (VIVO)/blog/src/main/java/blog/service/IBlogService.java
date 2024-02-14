package blog.service;

import blog.dto.EntradaBlogDTO;
import blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {
    Integer addEntradaBlog(EntradaBlogDTO entradaBlogDTO);
    EntradaBlogDTO findEntradaBlogById(Integer id);
    List<EntradaBlogDTO> findAllEntradasBlog();
}
