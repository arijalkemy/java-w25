package com.example.link_tracker.repository;

import com.example.link_tracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImp implements ILinkRepository{
    List<Link> links = new ArrayList<>();

    @Override
    public Link createLink(String url) {
        Link link = new Link(
                links.size() + 1,
                url,
                true,
                0
        );
        links.add(link);
        return link;
    }

    @Override
    public Link redirectLink(int id) {
        return links.get(id - 1);
    }

    @Override
    public Link LinksStatistics(int id) {
        this.links.get(id - 1).setCounter(this.links.get(id - 1).getCounter() + 1);
        return this.links.get(id - 1);
    }

    @Override
    public Link invalidateLink(int id) {
        Link link = links.get(id - 1);
        link.setValid(false);
        return link;
    }
}
