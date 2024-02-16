package com.ejemplo.linkTracker.repository;

import com.ejemplo.linkTracker.model.Link;

import java.util.Map;

public interface ILinkRepository {

    int create(Link link, int id);

    Map<Integer, Link> getMap();

    Link getLink(int id);

    void removeLink(int id);
}
