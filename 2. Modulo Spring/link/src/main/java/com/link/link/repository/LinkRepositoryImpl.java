package com.link.link.repository;

import com.link.link.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    HashMap<Integer, Link> links = new HashMap<Integer, Link>();
    ArrayList<Link> invalidLinks = new ArrayList<Link>();

    private int count = 0;

    @Override
    public int addLink(Link link) {
        this.count++;
        links.put(this.count, link);
        return this.count;
    }

    @Override
    public Link getLinkById(int id) {
        return links.get(id);
    }

    @Override
    public void addInvalidLink(int id) {
        Link linkToInvalid = links.remove(id);
        invalidLinks.add(linkToInvalid);
    }

    @Override
    public ArrayList<Link> getAllInvalidLinks() {
        return invalidLinks;
    }
}
