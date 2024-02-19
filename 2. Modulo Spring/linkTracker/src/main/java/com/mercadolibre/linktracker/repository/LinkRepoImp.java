package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.exception.NoAccessException;
import com.mercadolibre.linktracker.exception.NoActiveException;
import com.mercadolibre.linktracker.exception.NoFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepoImp implements  ILinkRepo<Link, Integer>{

    private Map<Integer, Link> mapLinks ;
    private Integer idCounter;

    public LinkRepoImp(){
        this.mapLinks = new HashMap<>();
        this.idCounter = 0;
    }

    @Override
    public Map<Integer, Link> getAll() {
        return this.mapLinks;
    }

    @Override
    public Link getById(Integer id, String password) {
        if(this.mapLinks.containsKey(id)){
            Link link = this.mapLinks.get(id);

            if (!link.getActive())
                throw new NoActiveException("Link Unable");

            if(link.getPassword().equals(password)){
                link.increseCounter();
                return link;
            }
            else{
                throw new NoAccessException("Acces denied wrong password");
            }
        }
        else {
            throw new NoFoundException("id Link no found");
        }
    }

    @Override
    public Link getById(Integer id){
        if(this.mapLinks.containsKey(id)) {
            return this.mapLinks.get(id);
        }
        else {
            throw new NoFoundException("id Link no found");
        }
    }

    @Override
    public Integer add(Link link) {
        idCounter++;
        this.mapLinks.put(idCounter,link);
        return  idCounter;
    }

    @Override
    public void disable(Integer id) {
        if(this.mapLinks.containsKey(id)){
            Link link = this.mapLinks.get(id);
            link.setActive(false);
       }
        else {
            throw new NoFoundException("id Link no found");
        }
    }
}
