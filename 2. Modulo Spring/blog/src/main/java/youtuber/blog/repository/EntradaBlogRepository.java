package youtuber.blog.repository;

import org.springframework.stereotype.Repository;
import youtuber.blog.entity.EntradaBlog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    private List<EntradaBlog> entradasBlogs = new ArrayList<>();

    @Override
    public List<EntradaBlog> getAll() {
        return entradasBlogs;
    }

    @Override
    public Optional<EntradaBlog> getById(Long id) {
        return entradasBlogs.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public EntradaBlog post(EntradaBlog entrada) {

        EntradaBlog entradaNueva = new EntradaBlog(
                entrada.getId(),
                entrada.getTitulo(),
                entrada.getAutor(),
                entrada.getFechaPublicacion()
        );

        entradasBlogs.add(entradaNueva);
        return entradaNueva;
    }
}
