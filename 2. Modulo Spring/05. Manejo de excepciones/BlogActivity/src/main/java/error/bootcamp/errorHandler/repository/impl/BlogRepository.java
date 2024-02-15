package error.bootcamp.errorHandler.repository.impl;

import error.bootcamp.errorHandler.entity.Blog;
import error.bootcamp.errorHandler.repository.common.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {

    private List<Blog> blogs;

    public BlogRepository() {
        this.blogs = new ArrayList<>();
    }

    @Override
    public Blog save(Blog blog) {
        this.blogs.add(blog);

        return blog;
    }

    @Override
    public Optional<Blog> getById(int id) {
        return this.blogs.stream().filter(blog -> blog.getId().equals(id)).findFirst();
    }

    @Override
    public List<Blog> getAll() {
        return this.blogs;
    }
}
