package org.example.linktracker.repository;

import org.example.linktracker.entity.Link;

public interface ILinkRepository {

    public Link createLink(Link link);

    public Link getLinkById(long linkId);

    public Link validateLinkPassword(String password, long linkId);

    public void redirectLink(long linkId);

    public boolean invalidateLink(long linkId);
}
