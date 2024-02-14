package bootcamp.excepcionesp1vivo.repository;

import bootcamp.excepcionesp1vivo.dto.BlogDTO;
import bootcamp.excepcionesp1vivo.exception.AlreadyExistException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private Map<Integer, BlogDTO> blogs = new HashMap<>();

    @Override
    public void createBlog(BlogDTO blog, Integer id) {
        BlogDTO blogFound = blogs.get(id);
        if (blogFound != null) throw new AlreadyExistException("El blog con el id " + id + " ya existe.");
        blogs.put(id, blog);
    }

    @Override
    public BlogDTO findById(Integer id) {
        return blogs.get(id);
    }

    @Override
    public Map<Integer, BlogDTO> findAll() {
        return blogs;
    }
}
