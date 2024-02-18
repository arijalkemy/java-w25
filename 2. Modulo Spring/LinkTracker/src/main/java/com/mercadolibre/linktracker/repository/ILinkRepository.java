package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;

import java.util.List;

public interface ILinkRepository {
    List<Link> findAll();
    Link findById(Integer id);
    void addLink(Link link);
    void invalidateLink(Integer id);
}
