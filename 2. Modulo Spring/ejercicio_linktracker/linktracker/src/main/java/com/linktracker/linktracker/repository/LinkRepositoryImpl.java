package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.entity.Link;
import com.linktracker.linktracker.exception.InvalidLinkException;
import com.linktracker.linktracker.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    List<Link> linkList = new ArrayList<>();
    int currentId=0;

    public LinkRepositoryImpl(){
        loadData();
    }

    private void loadData(){
        this.saveLink("https://www.google.com","password123");
        this.saveLink("https://www.mercadolibre.com", "password123");
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
        Optional<Link> linkFound= linkList.stream().filter(link->link.getUri().equals(uri)).findAny();

        if(linkFound.isEmpty()){
            Link newLink = new Link(this.currentId,uri,true,0, password);
            this.currentId++;
            this.linkList.add(newLink);
            return newLink;
        }
        throw new InvalidLinkException("This link already exists");
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
