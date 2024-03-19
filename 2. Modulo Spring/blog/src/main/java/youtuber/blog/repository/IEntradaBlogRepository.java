package youtuber.blog.repository;

import youtuber.blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {
    List<EntradaBlog> getAll();

    Optional<EntradaBlog> getById(Long id);

    EntradaBlog post(EntradaBlog entrada);
}
