package com.bootcamp.ejercicio_link_tracker.repository;

import com.bootcamp.ejercicio_link_tracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepositoryImp implements ILinkRepository {
    private final Map<Integer, Link> links = new HashMap<>();

    @Override
    public Link create(Link link) {
        if (link.getLinkId() == null)
            link.setLinkId(links.values().size());

        links.put(link.getLinkId(), link);
        return link;
    }

    @Override
    public Optional<Link> findById(Integer linkId) {
        Link link = links.get(linkId);
        return Optional.ofNullable(link);
    }

    @Override
    public void invalidate(Integer linkId) {
        links.get(linkId).setValid(false);
    }

    @Override
    public void addMetric(Integer linkId) {
        links.get(linkId).setMetrics(links.get(linkId).getMetrics()+1);
    }
}