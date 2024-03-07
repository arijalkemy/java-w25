package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.entity.Link;

public interface ILinkRepository {
    public Link saveLink(String uri, String password);

    public Link getLink(int id);

    public Link invalidateLink(int id);

}
