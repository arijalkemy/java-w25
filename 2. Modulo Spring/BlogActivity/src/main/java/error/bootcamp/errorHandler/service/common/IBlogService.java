package error.bootcamp.errorHandler.service.common;

import error.bootcamp.errorHandler.dto.blog.BlogDTO;
import error.bootcamp.errorHandler.dto.common.ResponseDto;

import java.util.List;

public interface IBlogService {
    ResponseDto create(BlogDTO blogDTO);

    BlogDTO getById(int id);

    List<BlogDTO> getAll();
}
