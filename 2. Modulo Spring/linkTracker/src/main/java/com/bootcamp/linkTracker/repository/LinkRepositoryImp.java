package com.bootcamp.linkTracker.repository;

import com.bootcamp.linkTracker.entity.Link;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public  class LinkRepositoryImp implements ILinkRepository {

    private Long contadorId = 0L;

    List<Link> links = new ArrayList<>(List.of(
            new Link(contadorId, "perez", "dsdss"),
            new Link(contadorId++, "martinez", "dhfkdsjh"),
            new Link(contadorId++, "paez", "jdhkdsjhf"))
    );

    public long getNextId(){
        this.contadorId++;
        return this.contadorId;
    }

    public List<Link> getAll() {
        return this.links;
    }

    public Link saveLink(Link link){
        this.links.add(link);
        return link;
    }

    public Optional<Link> getById(long id){
        return this.links.stream()
                        .filter(link -> link.getLinkId() == id)
                        .findFirst();
    }

    public void invalidateLink(long id){
        links.stream()
                .filter(link -> link.getLinkId() == id)
                .forEach(link -> link.setActive(false));
    }


}
