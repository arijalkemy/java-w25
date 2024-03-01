package org.socialmeli.repository;

import java.util.List;

public interface IRepository<E> {
     List<E> findAll();
     Integer save(E item);
     E findOne (Integer id);
     void deleteOne(Integer id);
}
