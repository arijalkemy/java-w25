package bootcamp.excepcionesp1vivo.service;

import bootcamp.excepcionesp1vivo.dto.BlogDTO;
import bootcamp.excepcionesp1vivo.entity.EntradaBlog;
import bootcamp.excepcionesp1vivo.exception.NotFoundException;
import bootcamp.excepcionesp1vivo.repository.BlogRepositoryImpl;
import bootcamp.excepcionesp1vivo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private BlogRepositoryImpl blogRepository;


    @Override
    public void createBlog(EntradaBlog blog) {
        BlogDTO blogDTO = Mapper.createBlogDTO(blog);
        blogRepository.createBlog(blogDTO, blog.getId());
    }

    @Override
    public EntradaBlog findById(Integer id) {
        BlogDTO blogDTO = blogRepository.findById(id);
        if (blogDTO == null) throw new NotFoundException(String.format("El blog con id " + id + " no fue encontrado."));
        return Mapper.createEntradaBlog(blogDTO, id);
    }

    @Override
    public List<EntradaBlog> findAll() {
        return blogRepository.findAll().entrySet().stream().map(b -> Mapper.createEntradaBlog(b.getValue(), b.getKey())).toList();
    }

}
