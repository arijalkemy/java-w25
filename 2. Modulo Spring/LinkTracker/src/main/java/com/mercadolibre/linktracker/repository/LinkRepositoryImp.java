package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkRepositoryImp implements ILinkRepository {
    private List<Link> links;

    public List<Link> findAll() {
        return links;
    }

    public Link findById(Integer id) {
        return links.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void invalidateLink(Integer id) {
        links.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .ifPresent(l -> l.setIsValid(Boolean.FALSE));
    }
}
