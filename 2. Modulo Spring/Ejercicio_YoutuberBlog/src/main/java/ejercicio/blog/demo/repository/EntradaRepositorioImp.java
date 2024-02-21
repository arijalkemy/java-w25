package ejercicio.blog.demo.repository;

import ejercicio.blog.demo.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaRepositorioImp implements IEntradaRepositorio {
    private List<EntradaBlog> listaEntradas = new ArrayList<>();

    @Override
    public void guardarPublicacion(EntradaBlog entrada) {
        listaEntradas.add(entrada);
    }

    @Override
    public List<EntradaBlog> getBlogs() {
        return listaEntradas;
    }
}
