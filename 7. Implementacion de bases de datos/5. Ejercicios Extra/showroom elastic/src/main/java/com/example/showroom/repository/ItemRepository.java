package com.example.showroom.repository;

import com.example.showroom.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item, String> {
    List<Item> findItemsBySaleId(String id);
}
