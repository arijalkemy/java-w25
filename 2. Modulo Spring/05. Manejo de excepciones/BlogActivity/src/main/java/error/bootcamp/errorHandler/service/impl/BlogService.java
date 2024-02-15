package error.bootcamp.errorHandler.service.impl;

import error.bootcamp.errorHandler.dto.blog.BlogDTO;
import error.bootcamp.errorHandler.dto.common.ResponseDto;
import error.bootcamp.errorHandler.entity.Blog;
import error.bootcamp.errorHandler.exception.BlogAlreadyExistsException;
import error.bootcamp.errorHandler.exception.BlogNotFoundException;
import error.bootcamp.errorHandler.repository.common.IBlogRepository;
import error.bootcamp.errorHandler.service.common.IBlogService;
import error.bootcamp.errorHandler.util.BlogMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    private IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    @Override
    public ResponseDto create(BlogDTO blogDTO) {
        Optional<Blog> blog = this.blogRepository.getById(blogDTO.getId());

        if (blog.isPresent()) {
            throw new BlogAlreadyExistsException("El id ya existe");
        }

        Blog createdBlog = this.blogRepository.save(BlogMapper.toBlog(blogDTO));

        return BlogMapper.toResponseDTO(createdBlog, "Blog creado correctamente");
    }

    @Override
    public BlogDTO getById(int id) {
        Optional<Blog> blog = this.blogRepository.getById(id);

        if (blog.isEmpty()) {
            throw new BlogNotFoundException("El id no existe");
        }

        return BlogMapper.toBlogDTO(blog.get());
    }

    @Override
    public List<BlogDTO> getAll() {
        return this.blogRepository.getAll().stream().map(BlogMapper::toBlogDTO).toList();
    }
}
