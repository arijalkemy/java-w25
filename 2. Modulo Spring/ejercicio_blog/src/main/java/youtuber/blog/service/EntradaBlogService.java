package youtuber.blog.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import youtuber.blog.DTO.request.CreateBlogPostRequest;
import youtuber.blog.DTO.request.GetBlogRequest;
import youtuber.blog.DTO.response.EntradaBlogDTO;
import youtuber.blog.entity.EntradaBlog;
import youtuber.blog.exception.AlreadyExistsException;
import youtuber.blog.exception.NotFoundBlogException;
import youtuber.blog.repository.EntradaBlogRepository;
import youtuber.blog.repository.IEntradaBlogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaBlogService implements IEntradaBlogService{
    private final IEntradaBlogRepository entradaBlogRepository;
    private final ModelMapper modelMapper;

    public EntradaBlogService (
            EntradaBlogRepository repository,
            ModelMapper modelMapper
    ) {
        this.entradaBlogRepository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EntradaBlogDTO getBlogById(Long id) {
        Optional<EntradaBlog> entradaBlog = entradaBlogRepository.getById(id);
        if(entradaBlog.isEmpty()) {
            throw new NotFoundBlogException(String.format("No se encontró el blog con ID %d", id));
        }
        return modelMapper.map(entradaBlog.get(), EntradaBlogDTO.class);
    }

    @Override
    public List<EntradaBlogDTO> getAll() {
        return entradaBlogRepository.getAll()
                .stream()
                .map(b -> modelMapper.map(b, EntradaBlogDTO.class))
                .toList();
    }

    @Override
    public EntradaBlogDTO postNew(CreateBlogPostRequest post) {
        if (!entradaBlogRepository.getById(post.getId()).isEmpty())
            throw new AlreadyExistsException(String.format("Ya existe un blog con ID %d", post.getId()));

        EntradaBlog newPost = modelMapper.map(post, EntradaBlog.class);
        return modelMapper
                .map(entradaBlogRepository.post(newPost), EntradaBlogDTO.class);
    }
}
