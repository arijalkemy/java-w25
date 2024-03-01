package org.bootcamp.javazoo.helper;

import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.exception.BadRequestException;
import org.bootcamp.javazoo.dto.UserDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionSorter {


    public static List<UserDto> sortUserDtoCollection(List<UserDto> collection, String order) {
        Comparator<UserDto> comparator;
        if (order == null || order.equals("name_asc")) {
            comparator = Comparator.comparing(UserDto::getUser_name);
        } else if (order.equals("name_desc")) {
            comparator = Comparator.comparing(UserDto::getUser_name).reversed();
        } else {
            throw new BadRequestException("'order' parameter in endpoint path is invalid");
        }
        return sortCollection(collection, comparator);
    }

    public static List<PostResponseDto> sortPostDtoByDate(List<PostResponseDto> posts, String order){
        if(order == null || order.equals("date_asc")){
            return CollectionSorter.sortCollection(posts, Comparator.comparing(PostResponseDto::getDate));
        } else if (order.equals("date_desc")) {
            return CollectionSorter.sortCollection(posts, Comparator.comparing(PostResponseDto::getDate).reversed());
        } else {
            throw new BadRequestException("'order' parameter in endpoint path is invalid");
        }
    }

    public static <T> List<T> sortCollection(List<T> collection, Comparator<T> comparator) {
        return collection.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
