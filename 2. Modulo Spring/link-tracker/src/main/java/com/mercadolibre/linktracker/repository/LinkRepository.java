package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository {
    private final Map<Integer, Link> links = new HashMap<>();

    public Link save(Link link) {
        if (link.getId() == null)
            link.setId(links.values().size());
        links.put(link.getId(), link);
        return link;
    }

    public Optional<Link> findById(Integer linkId) {
        return Optional.ofNullable(links.get(linkId));
    }

    public Optional<Link> delete(Integer linkId) {
        return Optional.ofNullable(links.remove(linkId));
    }
}
