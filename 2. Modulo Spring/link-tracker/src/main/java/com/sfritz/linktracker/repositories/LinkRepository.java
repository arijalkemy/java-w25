package com.sfritz.linktracker.repositories;

import org.springframework.stereotype.Repository;

import com.sfritz.linktracker.entities.Link;
import com.sfritz.linktracker.util.DataBase;

@Repository
public class LinkRepository implements ILinkRepository{

    private DataBase db;

    public LinkRepository(DataBase db){
        this.db = db;
    }
    
    @Override
    public Link createLink(Link link) {
        return this.db.createLink(link);
    }

}
