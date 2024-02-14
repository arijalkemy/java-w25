package blog.repository;

import blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    boolean save(EntradaBlog entradaBlog);
    EntradaBlog findById(Integer id);
    List<EntradaBlog> findAll();
}
