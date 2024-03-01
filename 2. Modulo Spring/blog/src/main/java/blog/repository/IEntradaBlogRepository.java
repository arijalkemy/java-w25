package blog.repository;

import blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    public List<EntradaBlog> getAll();

    public EntradaBlog getBlogByID(int id);

    public Integer addBlog(EntradaBlog entradaBlog);
}
