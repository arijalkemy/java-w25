package agencia.repository;

import java.util.List;
import java.util.Optional;

public interface Repository <T>{

    public List<T> getAll();

    public Optional<T> getOne(int id);

    public T insert(T elementInsert);

    public T update(T elementUpdate);

    public T delete(int id);

}
