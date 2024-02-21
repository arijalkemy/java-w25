package com.sfritz.linktracker.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sfritz.linktracker.entities.Link;

@Component
public class DataBase {

    private static Long idGenerator = 0L;
    private List<Link> links;

    public DataBase(){
        this.links = new ArrayList<>();
    }

    public Link createLink(Link link){
        link.setLinkId(++idGenerator);
        this.links.add(link);
        return this.links.get(this.links.size()-1);
    }
}
