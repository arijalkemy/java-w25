package Interfaces;
import java.util.List;

public interface ICRUD<T>{
    public void create(T t);
    public List<T> read();
    public void update (T t);
    public void delete(T t);
    public T findById(int id);


}
