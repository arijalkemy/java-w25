package com.spring.linktracker.repository;

import java.util.List;

import com.spring.linktracker.model.Link;

public interface ILinkRepository {
    public List<Link> getLinks();

    public Link postLink(Link link);

    public void putLink(Link link);

    public Link getMetrics(Integer id);
}
