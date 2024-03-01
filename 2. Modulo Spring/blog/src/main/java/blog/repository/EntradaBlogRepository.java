package blog.repository;

import blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    private List<EntradaBlog> blogs;

    @Override
    public List<EntradaBlog> getAll(){ return this.blogs;}

    @Override
    public EntradaBlog getBlogByID(int id){
        EntradaBlog blog = this.blogs.stream()
                .filter(b -> b.getId().equals(id))
                .findAny().orElse(null);
        return blog;
    }
    @Override
    public Integer addBlog(EntradaBlog entradaBlog){
        if (!blogs.contains(entradaBlog)){
            blogs.add(entradaBlog);
            return entradaBlog.getId();
        }
        return -1;
    }
}
