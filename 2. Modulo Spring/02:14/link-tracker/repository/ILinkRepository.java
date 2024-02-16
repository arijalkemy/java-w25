package com.linktraker.ejercicio2.repository;

import java.util.List;

import com.linktraker.ejercicio2.model.Link;

public interface ILinkRepository {
    public List<Link> getLinks();

    public Link postLink(Link link);

    public void putLink(Link link);
}
