package main.repository;

import main.entity.EntryBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EntryBlogRepositoryImpl implements IEntryBlogRepository{

    private List<EntryBlog> entrys = new ArrayList<>(
            Arrays.asList(
                    new EntryBlog(1,"entrada1", "autor1", "02/03/2010"),
                    new EntryBlog(2,"entrada2", "autor2", "02/03/2010")
            )
    );

    @Override
    public EntryBlog addEntryBlog(EntryBlog entry) {
        entrys.add(entry);
        return entry;
    }

    @Override
    public EntryBlog getEntryBlogById(int id) {
        return entrys.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<EntryBlog> getAllEntryBlog() {
        return entrys;
    }
}
