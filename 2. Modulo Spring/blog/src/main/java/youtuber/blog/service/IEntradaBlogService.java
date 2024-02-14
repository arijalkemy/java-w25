package youtuber.blog.service;

import youtuber.blog.DTO.request.CreateBlogPostRequest;
import youtuber.blog.DTO.response.EntradaBlogDTO;
import youtuber.blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {
    public EntradaBlogDTO getBlogById (Long id);
    public List<EntradaBlogDTO> getAll();
    public EntradaBlogDTO postNew(CreateBlogPostRequest post);
}
