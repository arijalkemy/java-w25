package blog.repository;

import blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    private Map<Integer, EntradaBlog> entradasBlog = new HashMap<>();

    @Override
    public boolean save(EntradaBlog entradaBlog) {
        if (entradasBlog.containsKey(entradaBlog.getId())) {
            return false;
        }
        entradasBlog.put(entradaBlog.getId(), entradaBlog);
        return true;
    }

    @Override
    public EntradaBlog findById(Integer id) {
        return entradasBlog.get(id);
    }

    @Override
    public List<EntradaBlog> findAll() {
        return entradasBlog.values().stream().toList();
    }
}
