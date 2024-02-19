package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogDto;
import com.mercadolibre.blog.repository.BlogRepoImp;
import com.mercadolibre.blog.utils.Mapeador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    private BlogRepoImp blogRepo;

    public BlogService(BlogRepoImp blogRepo) {
        this.blogRepo = blogRepo;
    }

    public void add(BlogDto blogDto){

        this.blogRepo.add(blogDto.getId(), Mapeador.mapDtoToEntity(blogDto));
    }

    public BlogDto findById(Integer id){
        return  Mapeador.mapEntityToDt(id,this.blogRepo.getById(id));
    }

    public List<BlogDto> getAll(){
        List<BlogDto> blogDtoList = new ArrayList<>();
        this.blogRepo.getAll().forEach((k,v)-> blogDtoList.add(Mapeador.mapEntityToDt(k,v)));
        return  blogDtoList;
    }

}
