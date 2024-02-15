package error.bootcamp.errorHandler.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import error.bootcamp.errorHandler.dto.blog.BlogDTO;
import error.bootcamp.errorHandler.dto.common.ResponseDto;
import error.bootcamp.errorHandler.entity.Blog;

public class BlogMapper {
    public static Blog toBlog(BlogDTO blogDTO){
        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper.convertValue(blogDTO,Blog.class);
    }

    public static BlogDTO toBlogDTO(Blog blog){
        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper.convertValue(blog,BlogDTO.class);
    }

    public static ResponseDto toResponseDTO(Blog blog,String message){
        return new ResponseDto(blog.getId(),message);
    }
}
