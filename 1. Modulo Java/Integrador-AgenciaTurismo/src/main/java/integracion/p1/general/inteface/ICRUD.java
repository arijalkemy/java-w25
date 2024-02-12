package integracion.p1.general.inteface;

import java.util.List;

public interface ICRUD <T, u> {

    public T create(T element);
    public T getBy(u id);
    public List<T> getAll();
    public T updateBy(u id, T element);
    public void deleteBy(u id);
}
