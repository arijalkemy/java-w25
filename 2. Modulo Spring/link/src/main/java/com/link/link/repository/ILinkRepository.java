package com.link.link.repository;

import com.link.link.entity.Link;

import java.util.ArrayList;

public interface ILinkRepository {

    void addInvalidLink(int id);
    ArrayList<Link> getAllInvalidLinks();
    int addLink(Link link);
    Link getLinkById(int id);
}
