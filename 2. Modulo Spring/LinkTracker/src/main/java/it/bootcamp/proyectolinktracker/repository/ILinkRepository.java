package it.bootcamp.proyectolinktracker.repository;

import it.bootcamp.proyectolinktracker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link create(Link link);
    Optional<Link> findById(Integer linkId);
    void invalidate(Integer linkId);
    void addMetric(Integer linkId);
}