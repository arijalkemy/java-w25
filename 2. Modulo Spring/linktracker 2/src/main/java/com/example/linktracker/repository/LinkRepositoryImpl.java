package com.example.linktracker.repository;

import com.example.linktracker.dto.request.LinkIdMetricsDTO;
import com.example.linktracker.dto.request.RedirectRequestDTO;
import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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
        this.links.add(link);
        return link.getId();
    }



    @Override
    public boolean invalidateLink(int linkID){
        Optional<Link> linkEncontrado = this.links.stream().filter(link -> link.getId() == linkID).findFirst();
        if (linkEncontrado.isPresent()) {
            linkEncontrado.get().setValido(false);
            return true;
        }
        return false;
    }

    @Override
    public Integer getMetrics(LinkIdMetricsDTO link) {

        Optional<Link> linkBuscado = links.stream().filter(l -> l.getId() == link.getLinkId()).findFirst();
        return linkBuscado.map(Link::getContador).orElse(null);
    }
}
