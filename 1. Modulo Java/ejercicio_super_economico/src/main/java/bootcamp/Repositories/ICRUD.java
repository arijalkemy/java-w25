package bootcamp.Repositories;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T>{
    public void save(T saved);
    public List<T> getAll();

    public void remove(T removed);
}
