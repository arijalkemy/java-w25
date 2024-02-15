package link_tracker.service;

import link_tracker.dto.LinkDTO;
import link_tracker.dto.request.CreateLinkDTO;
import link_tracker.dto.response.MetricsDTO;
import link_tracker.dto.response.SuccessDTO;
import link_tracker.entity.Link;
import link_tracker.exception.InvalidLinkException;
import link_tracker.exception.NotFoundException;
import link_tracker.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkTrackerService implements ILinkTrackerService{
    @Autowired
    ILinkTrackerRepository repository;

    private Link getLinkById(Long id){
        Optional<Link> link = this.repository.getById(id);
        if (link.isPresent()){
            if (link.get().isValid()){
                return link.get();
            }

            throw new InvalidLinkException("Link invalido");
        }

        else{
            throw new NotFoundException("Link no encontrado");
        }
    }

    public Link getLink(Long id, String password) {
        Link link = this.getLinkById(id);
        String linkPassword = link.getPassword();
        if (!linkPassword.equals("")){
            if (password != null){
                if (linkPassword.equals(password)){
                    link.setMetrics(link.getMetrics() + 1);
                    return link;
                } else{
                    throw new InvalidLinkException("Contraseña incorrecta");
                }
            } else{
                throw new InvalidLinkException("Link con contraseña. Ingrese la contraseña");
            }
        } else {
            link.setMetrics(link.getMetrics() + 1);
            return link;
        }
    }

    public LinkDTO createLink(CreateLinkDTO link){
        Pattern pattern = Pattern.compile("^((https)?(www\\.)?).+(\\.com(/(/d|[A-Z])+)*)/?$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(link.getUrl());
        if(matcher.find()){
            Link linkToSave =new Link(0L, link.getUrl(), link.getPassword(), 0, true);
            return new LinkDTO(repository.save(linkToSave).getId());
        }else{
            throw new InvalidLinkException("El link ingresado no es un link valido");
        }
    }

    public MetricsDTO getLinkMetrics(Long linkId){
        Link link = this.getLinkById(linkId);
        return new MetricsDTO(link.getUrl(), link.getMetrics());
    }

    public SuccessDTO invalidateLink(Long linkId){
        Link link = this.getLinkById(linkId);
        link.setValid(false);
        return new SuccessDTO("Link invalidado con éxito");
    }
}