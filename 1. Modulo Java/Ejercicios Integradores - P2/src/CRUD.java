public interface CRUD <T>{
void add(T t);
T search(String id);
void delete(String id);
void update(T t);
}
