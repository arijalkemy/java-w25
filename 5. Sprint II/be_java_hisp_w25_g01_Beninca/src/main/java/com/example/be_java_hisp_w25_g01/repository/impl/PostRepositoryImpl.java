package com.example.be_java_hisp_w25_g01.repository.impl;

import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.repository.IPostRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    private List<Post> listOfPost;
    public PostRepositoryImpl(){
        loadPost();
    }
    private void loadPost(){
        this.listOfPost =  new ArrayList<>(List.of(
                new Post(1,4, LocalDate.of(2024, Month.FEBRUARY,18), 1, 100, 1500.50),
                new Post(2,4, LocalDate.of(2024, Month.MAY,01), 62, 120, 2800.69),
                new Post(3,5, LocalDate.of(2024, Month.JANUARY,29),1, 100, 1500.00),
                new Post(4, 5, LocalDate.of(2024, Month.FEBRUARY, 15), 2,110, 200.41),
                new Post(5, 4, LocalDate.of(2024, Month.FEBRUARY, 12), 3, 100, 500.00),
                new Post(6, 4, LocalDate.of(2023, Month.JANUARY, 01), 4,110, 200000.00)
        ));
    }

    public List<Post> getAll(){
        return listOfPost;
    };
    public Optional<Post> findById(Integer id){
        return listOfPost.stream()
                .filter(p-> id.equals(p.getPost_id()))
                .findFirst();
    };

    public List<Post> findByUser(Integer userId){
        return listOfPost.stream()
                .filter(p-> userId.equals(p.getUser_id()))
                .toList();
    };

    public void addPost(Post post){
        listOfPost.add(post);
    }

    public Integer generateId(){
        return listOfPost.get(listOfPost.size()-1).getPost_id()+1;
    }

    @Override
    public List<Post> findAllPostById(List<Integer> postIds) {
        return listOfPost.stream()
                .filter(post -> postIds.contains(post.getPost_id()))
                .collect(Collectors.toList());
    }
}
