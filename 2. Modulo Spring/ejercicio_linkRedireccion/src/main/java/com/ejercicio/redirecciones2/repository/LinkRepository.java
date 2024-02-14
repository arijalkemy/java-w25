package com.ejercicio.redirecciones2.repository;

import com.ejercicio.redirecciones2.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class LinkRepository implements ILinkRepository {

    Map<Integer, Link> linkMap = new HashMap<>();

    @Override
    public Link addLink(Link link) {
        Link newlink = linkMap.putIfAbsent(link.getId(), link);
        if(newlink== null){
            return link;
        }

        return null;
    }

    @Override
    public Link findLinkById(Integer id) {
        if(linkMap.get(id)== null){
            return null;
        }

        return linkMap.get(id);
    }

    @Override
    public Boolean invalidateLink(Integer id) {
        if (findLinkById(id)== null){
            return null;
        }
        linkMap.get(id).setStatus(false);
        return false;
    }
}
