package org.example.linktracker.repository;

import org.example.linktracker.entity.Link;
import org.example.linktracker.exception.BadRequestLinkException;
import org.example.linktracker.exception.NotFoundException;
import org.example.linktracker.exception.PersistenceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    List<Link> links;

    public LinkRepository(){
        links = new ArrayList<>();
    }
    @Override
    public Link createLink(Link link) {
        links.add(link);
        if(!links.contains(link)) throw new PersistenceException("No fue posible crear el link");
        return link;
    }

    @Override
    public Link getLinkById(long linkId) {
        return links.stream().filter(link -> link.getId() == linkId).findFirst().orElse(null);
    }

    public Link validateLinkPassword(String password, long linkId){
        Link searchLink = getLinkById(linkId);
        if(searchLink == null) throw new NotFoundException("No se encontro el link");
        if(!searchLink.getPassword().equals(password)) throw new BadRequestLinkException("Id o password invalidos");
        return searchLink;
    }

    @Override
    public void redirectLink(long linkId) {
        getLinkById(linkId).redirect();
    }

    @Override
    public boolean invalidateLink(long linkId) {
        Link link = getLinkById(linkId);
        return link.invalidate();
    }
}
