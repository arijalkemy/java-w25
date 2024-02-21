public interface IOperations<T> {
    void create(T t);
    void update(T t);
    void read();
    T readById(Long id);
    void delete(Long id);
}
