package org.example.manejo_de_excepciones_p1_vivo.repository;

import org.example.manejo_de_excepciones_p1_vivo.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements BlogRepositoryInterface {
    private List<EntradaBlog> blogRepositoryList = new ArrayList<>();

    @Override
    public void insertNewBlog(EntradaBlog blog) {
        blogRepositoryList.add(blog);
    }

    @Override
    public Optional<EntradaBlog> findOneBlogById(int id) {
        return blogRepositoryList.stream().filter(item -> item.getId() == id).findFirst();
    }

    @Override
    public List<EntradaBlog> findAllBlogs() {
        return blogRepositoryList;
    }
}
