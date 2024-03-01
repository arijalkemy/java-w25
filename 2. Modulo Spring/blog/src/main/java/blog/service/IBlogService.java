package blog.service;

import blog.dto.request.EntradaBlogDTO;

import java.util.List;

public interface IBlogService {

    public EntradaBlogDTO getBlogById(int id);
    public List<EntradaBlogDTO> getAll();
    public Integer addBlog(EntradaBlogDTO entradaBlogDTO);
}
