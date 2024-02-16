package com.spring.linktracker.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.linktracker.model.Link;

@Repository
public class LinkRepository implements ILinkRepository {
    private List<Link> linkList;

    public LinkRepository() {
        this.linkList = new ArrayList<>();
    }

    @Override
    public Link postLink(Link link) {
        this.linkList.add(link);
        return link;
    }

    @Override
    public List<Link> getLinks() {
        return this.linkList;
    }

    @Override
    public void putLink(Link link) {
        for (int i = 0; i < this.linkList.size(); i++) {
            if (this.linkList.get(i).getId().intValue() == link.getId().intValue()) {
                this.linkList.set(i, link);
            }
        }
    }

    @Override
    public Link getMetrics(Integer id) {
        for (int i = 0; i < this.linkList.size(); i++) {
            if (this.linkList.get(i).getId().intValue() == id.intValue()) {
                this.linkList.get(i);
            }
        }
        return null;
    }

}
