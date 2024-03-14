package com.jpa.relations.repositorory;

import com.jpa.relations.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<Item,Long> {
}
