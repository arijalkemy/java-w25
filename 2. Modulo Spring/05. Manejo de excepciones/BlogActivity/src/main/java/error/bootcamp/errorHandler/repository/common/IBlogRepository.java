package error.bootcamp.errorHandler.repository.common;

import error.bootcamp.errorHandler.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Blog save(Blog blog);
    Optional<Blog> getById(int id);
    List<Blog> getAll();
}
