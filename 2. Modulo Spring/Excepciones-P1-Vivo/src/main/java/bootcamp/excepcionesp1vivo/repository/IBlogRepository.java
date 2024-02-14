package bootcamp.excepcionesp1vivo.repository;

import bootcamp.excepcionesp1vivo.dto.BlogDTO;

import java.util.Map;

public interface IBlogRepository {

    void createBlog(BlogDTO blog, Integer id);

    BlogDTO findById(Integer id);

    Map<Integer, BlogDTO> findAll();

}
