package com.bootcamp.ejercicio_link_tracker.repository;

import com.bootcamp.ejercicio_link_tracker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link create(Link link);
    Optional<Link> findById(Integer linkId);
    void invalidate(Integer linkId);
    void addMetric(Integer linkId);
}