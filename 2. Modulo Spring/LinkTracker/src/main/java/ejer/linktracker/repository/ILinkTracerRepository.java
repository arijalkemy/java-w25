package ejer.linktracker.repository;

import ejer.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ILinkTracerRepository {

    public void addLink(Link link);
    public Link getById(int id);
    public List<Link> getAll();
    public void updateEsValido(int id);
    public void updateRedirects(int id);
}
