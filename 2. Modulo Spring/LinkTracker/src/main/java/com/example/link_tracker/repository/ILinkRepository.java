package com.example.link_tracker.repository;

import com.example.link_tracker.entity.Link;

import java.util.List;

public interface ILinkRepository {

    public Link createLink(String url);

    public Link redirectLink(int id);

    public Link LinksStatistics(int id);

    public Link invalidateLink(int id);


}
