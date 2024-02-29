package org.bootcamp.javazoo.helper;

import org.bootcamp.javazoo.entity.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FilterListByWeeks {
    public static List<Post> filterPostsByWeeksAgo(int weeks, List<Post> posts){
        LocalDate weeksAgo = LocalDate.now().minusWeeks(weeks);
        return posts.stream()
                .filter(post -> post.getDate().isAfter(weeksAgo))
                .collect(Collectors.toList());
    }
}
