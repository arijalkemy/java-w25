package com.ejemplo.linkTracker.repository;

import com.ejemplo.linkTracker.exception.NotFoundException;
import com.ejemplo.linkTracker.exception.ObjectDuplicateException;
import com.ejemplo.linkTracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepositoryImp implements ILinkRepository{

    public Map<Integer, Link> list = new HashMap<>();
    @Override
    public int create(Link link, int id) {
        this.list.put(id, link);
        return id;
    }

    @Override
    public Map<Integer, Link> getMap() {
        return this.list;
    }

    @Override
    public Link getLink(int id) {
        if (!this.list.containsKey(id)) throw new NotFoundException("Elemento no encontrado");
        return this.list.get(id);
    }

    @Override
    public void removeLink(int id) {
        this.list.remove(id);
    }
}
