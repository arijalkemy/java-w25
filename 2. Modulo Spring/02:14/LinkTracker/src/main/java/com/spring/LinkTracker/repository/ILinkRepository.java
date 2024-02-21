package com.spring.LinkTracker.repository;

import java.util.List;

import com.spring.LinkTracker.model.Link;

public interface ILinkRepository {
    public List<Link> getLinks();

    public Link postLink(Link link);

    public void putLink(Link link);

    public Link getMetrics(Integer id);
}
