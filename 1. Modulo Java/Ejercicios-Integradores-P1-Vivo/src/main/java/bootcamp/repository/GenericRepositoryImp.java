package bootcamp.repository;

import bootcamp.domain.GenericObject;

import java.util.*;

public class GenericRepositoryImp <T extends GenericObject> implements IGenericRepository <T> {

    private final Map<Integer, T> mapOfObjects = new HashMap<>();

    @Override
    public void save(T genericObject) {
        mapOfObjects.put(genericObject.getId(), genericObject);
    }

    @Override
    public Optional<T> findById(Integer id) {
        return mapOfObjects.get(id) == null ? Optional.empty() : Optional.of(mapOfObjects.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(mapOfObjects.values());
    }

    @Override
    public void update(T genericObject, Integer id) {
        if (mapOfObjects.containsKey(id)) mapOfObjects.put(id, genericObject);
        else System.out.println("El elemento que se quiere modificar no se encuentra en el repositorio.");
    }

    @Override
    public T deleteById(Integer id) {
        if (mapOfObjects.containsKey(id)) return mapOfObjects.remove(id);
        System.out.println("El elemento que se quiere eliminar no se encuentra en el repositorio.");
        return null;
    }
}
