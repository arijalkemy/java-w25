package repository;

import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.repository.IPostRepository;
import com.example.be_java_hisp_w25_g01.repository.impl.PostRepositoryImpl;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.Month;

public class PostRepositoryImpTest {

    IPostRepository postRepository = new PostRepositoryImpl();

    @Test
    void findAllByIdIn() {
        List<Integer> postIds = List.of(2);

        List<Post> users = postRepository.findAllPostById(postIds);

        assertEquals(62, users.get(0).getProduct());
    }

    @Test
    void findByIdOK(){
        Integer id = 1;
        Post expectedPost = new Post(1,4, LocalDate.of(2024, Month.FEBRUARY,18), 1, 100, 1500.50);

        Post currentPost = postRepository.findById(id).get();

        Assertions.assertEquals(currentPost, expectedPost);
    }
}
