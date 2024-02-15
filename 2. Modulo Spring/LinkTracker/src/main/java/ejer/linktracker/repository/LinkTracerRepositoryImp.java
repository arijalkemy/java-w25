package ejer.linktracker.repository;

import ejer.linktracker.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTracerRepositoryImp implements ILinkTracerRepository {

    private List<Link> links = new ArrayList<>();

    @Override
    public void addLink(Link link) {
        links.add(link);
    }

    @Override
    public Link getById(int id) {
        for (Link link : links) {
            if (link.getId() == id) {
                return link;
            }
        }
        return null;
    }

    @Override
    public List<Link> getAll() {
        return links;
    }

    @Override
    public void updateEsValido(int id) {
        for (Link link : links) {
            if (link.getId() == id) {
                link.setEsValido(false);
                break;
            }
        }
    }

    @Override
    public void updateRedirects(int id) {
        for (Link link : links) {
            if (link.getId() == id) {
                link.aumentarContador();
                break;
            }
        }
    }
}
