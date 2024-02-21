package blog.service;

import blog.dto.request.EntradaBlogDTO;
import blog.entity.EntradaBlog;
import blog.exceptions.AlreadyExistsException;
import blog.exceptions.NotFoundException;
import blog.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlogService implements IBlogService{
    @Autowired
    EntradaBlogRepository blogRepository;

    @Override
    public EntradaBlogDTO getBlogById(int id){
        if (blogRepository.getBlogByID(id) == null){
            throw  new NotFoundException("No se encontró el blog con id: " + id);
        } else {
            EntradaBlog blog = blogRepository.getBlogByID(id);

            return new EntradaBlogDTO(blog.getId(),blog.getTitulo(),blog.getNombreAutor(), blog.getFechaDePublicacion());
        }
    }

    @Override
    public List<EntradaBlogDTO> getAll(){
        List<EntradaBlogDTO> listaBlogsDTO = new ArrayList<>();
        this.blogRepository.getAll().stream()
                .forEach(blog -> listaBlogsDTO.add(new EntradaBlogDTO(blog.getId(), blog.getTitulo(), blog.getNombreAutor(), blog.getFechaDePublicacion())));
        return listaBlogsDTO;

    }

    @Override
    public Integer addBlog(EntradaBlogDTO entradaBlogDTO){
        EntradaBlog entradaBlog = new EntradaBlog(entradaBlogDTO.getId(), entradaBlogDTO.getTitulo(), entradaBlogDTO.getNombreAutor(), entradaBlogDTO.getFechaDePublicacion());
        Integer blogID = blogRepository.addBlog(entradaBlog);
        if (blogID < 0){
            throw new AlreadyExistsException("La entrada de blog con id: " + blogID + " ya existe");
        } else {
            return blogID;
        }
    }

}
