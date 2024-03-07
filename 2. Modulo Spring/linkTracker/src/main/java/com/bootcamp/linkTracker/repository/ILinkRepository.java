package com.bootcamp.linkTracker.repository;

import com.bootcamp.linkTracker.entity.Link;

import java.util.List;
import java.util.Optional;

public interface ILinkRepository {

    List<Link> getAll();
    Link saveLink(Link link);

    Optional<Link> getById(long id);
    void invalidateLink(long id);

    long getNextId();


}
