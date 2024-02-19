package bootcamp.excepcionesp1vivo.service;

import bootcamp.excepcionesp1vivo.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {

    void createBlog(EntradaBlog blog);

    EntradaBlog findById(Integer id);

    List<EntradaBlog> findAll();
    
}
