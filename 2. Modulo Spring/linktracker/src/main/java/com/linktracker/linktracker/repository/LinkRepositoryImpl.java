package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.entity.Link;
import com.linktracker.linktracker.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    List<Link> linkList = new ArrayList<>();
    int currentId=0;

    public LinkRepositoryImpl(){
        loadData();
    }

    private void loadData(){
        this.saveLink("www.google.com","password123");
        this.saveLink("www.mercadolibre.com", "password123");
    }

    public Link getLink(int id){
        for(Link link: linkList){
            if(link.getId()==id){
                return link;
            }
        }

        linkList.stream().filter(link -> link.getId() == id).findFirst() ;
        return null;
    }

    public Link saveLink(String uri, String password){
        for(Link link: linkList){
            if(link.getUri()==uri){
              // throw new
            }
        }

        Link newLink = new Link(this.currentId,uri,true,0, password);
        this.currentId++;
        this.linkList.add(newLink);
        return newLink;
    }

    public Link invalidateLink(int id) {
        Link link = getLink(id);

        if (link == null){
            throw new NotFoundException("No se encontró un link con ese ID");
        }

        link.setValido(false);
        return link;
    }
}
