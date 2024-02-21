package ejercicio.blog.demo.service;

import ejercicio.blog.demo.dto.EntradaDTO;

import java.util.HashMap;
import java.util.List;

public interface IEntradaServicio {
    public void guardarPubli(EntradaDTO entrada);
    public EntradaDTO getPubliById(Integer id);
    public List<EntradaDTO> getBlogs();
}
