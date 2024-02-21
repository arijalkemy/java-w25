package ejercicio.blog.demo.repository;

import ejercicio.blog.demo.dto.EntradaDTO;
import ejercicio.blog.demo.model.EntradaBlog;

import java.util.List;

public interface IEntradaRepositorio {
    public void guardarPublicacion(EntradaBlog entrada);
    public List<EntradaBlog> getBlogs();
}
