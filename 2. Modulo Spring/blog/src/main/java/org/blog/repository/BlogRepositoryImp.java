package org.blog.repository;

import org.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepositoryImp implements IBlogRepository {

   private  Map<Long, EntradaBlog> entradas = new HashMap<>();

   @Override
   public Map<Long,EntradaBlog> getAll(){
       return entradas;
   }

   @Override
   public EntradaBlog findById(Long id){
       return entradas.get(id);
   }

   @Override
   public void addElement(EntradaBlog entry){
      this.entradas.put(entry.getId(), entry);
   }

}
