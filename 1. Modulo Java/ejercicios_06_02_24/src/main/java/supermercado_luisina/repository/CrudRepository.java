package supermercado_luisina.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T objeto);

    void mostrar();

    Optional<T> buscar(Long id);

    void eliminar(Long id);

    List<T> traerTodos();
}
