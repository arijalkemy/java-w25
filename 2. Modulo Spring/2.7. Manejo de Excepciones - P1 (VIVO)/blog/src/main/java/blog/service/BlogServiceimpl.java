package blog.service;

import blog.dto.EntradaBlogDTO;
import blog.entity.EntradaBlog;
import blog.exception.AlreadyExistsException;
import blog.exception.NotFoundException;
import blog.repository.BlogRepositoryImpl;
import blog.repository.IBlogRepository;
import blog.utils.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceimpl implements IBlogService {
    private final IBlogRepository blogRepository;

    public BlogServiceimpl(BlogRepositoryImpl blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Integer addEntradaBlog(EntradaBlogDTO entradaBlogDTO) {
        boolean saved = blogRepository.save(EntityMapper.entradaBlogMapperEntity(entradaBlogDTO));
        if (saved) {
            return entradaBlogDTO.getId();
        } else {
            throw new AlreadyExistsException("La entrada de blog con id " + entradaBlogDTO.getId() + " ya existe");
        }
    }

    @Override
    public EntradaBlogDTO findEntradaBlogById(Integer id) {
        EntradaBlog entradaBlog = blogRepository.findById(id);
        if (entradaBlog == null) {
            throw new NotFoundException("La entrada de blog con id " + id + " no existe");
        }
        return EntityMapper.entradaBlogMapperDTO(entradaBlog);
    }

    @Override
    public List<EntradaBlogDTO> findAllEntradasBlog() {
        return blogRepository.findAll().stream()
                .map(EntityMapper::entradaBlogMapperDTO)
                .toList();
    }
}
