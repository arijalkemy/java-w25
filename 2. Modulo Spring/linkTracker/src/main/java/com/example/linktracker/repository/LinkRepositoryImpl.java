package com.example.linktracker.repository;

import com.example.linktracker.dto.request.LinkIdMetricsDTO;
import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    List<Link> links;
    public LinkRepositoryImpl(){
        this.links = new ArrayList<>();
    }

    @Override
    public Link getById(int id) {
        Optional<Link> link = this.links.stream().filter(l -> l.getId() == id).findFirst();
        return  link.orElse(null);
    }

    @Override
    public int save(Link link){
        link.setId(this.links.size());
        link.setValido(true);
        link.setContador(0);
        this.links.add(link);
        return link.getId();
    }

    @Override
    public boolean invalidateLink(int linkID){
        boolean found = false;
        ListIterator<Link> it = this.links.listIterator();
        while (it.hasNext()) {
            Link l = it.next();
            if (l.getId() == linkID) {
                found = true;
                l.setValido(false);
                it.set(l);
            }
        }
        return found;
    }

    @Override
    public Integer getMetrics(LinkIdMetricsDTO link) {

        Optional<Link> linkBuscado = links.stream().filter(l -> l.getId() == link.getLinkId()).findFirst();
        return linkBuscado.map(Link::getContador).orElse(null);
    }

    @Override
    public void incrementCounter(int linkId) {
        ListIterator<Link> it = this.links.listIterator();
        while (it.hasNext()) {
            Link l = it.next();
            if (l.getId() == linkId) {
                l.setContador(1 + l.getContador());
                it.set(l);
            }
        }
    }


}
