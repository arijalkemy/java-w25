package bootcamp.repository;

import bootcamp.domain.GenericObject;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository <T extends GenericObject> {

    void save(T genericObject);

    Optional<T> findById(Integer id);

    List<T> findAll();

    void update(T genericObject, Integer id);

    T deleteById(Integer id);

}
