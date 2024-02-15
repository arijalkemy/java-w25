package linkTracker.service;

import linkTracker.dto.request.LinkDTO;
import linkTracker.dto.response.CreatedLinkDTO;
import linkTracker.dto.response.InvalidatedDTO;
import linkTracker.dto.response.MetricsDTO;
import linkTracker.entity.Link;
import linkTracker.exception.AlreadyInvalidatedLinkException;
import linkTracker.exception.InvalidLinkException;
import linkTracker.exception.InvalidPasswordException;
import linkTracker.exception.LinkNotFoundException;
import linkTracker.repository.ILinkRepository;
import linkTracker.repository.LinkRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService{

    private ILinkRepository linkRepository;

    public LinkServiceImpl(LinkRepositoryImp linkRepository){
        this.linkRepository = linkRepository;
    }

    @Override
    public CreatedLinkDTO create(LinkDTO link) {
        Link linkToCreate = new Link();
        linkToCreate.setActive(true);
        linkToCreate.setUrl(link.getUrl());
        linkToCreate.setPassword(link.getPassword());
        linkToCreate.setCount(0);

        int linkId = linkRepository.upsert(linkToCreate);

        return new CreatedLinkDTO(linkId);
    }

    @Override
    public MetricsDTO getMetrics(int id, String password) {
        Optional<Link> optionalLink = linkRepository.getById(id);

        if (optionalLink.isEmpty()) {
            throw new LinkNotFoundException("Link with id " + id + " not found.");
        }

        Link link = optionalLink.get();

        if (!link.getPassword().equals(password)) {
            throw new InvalidPasswordException("Incorrect password");
        }

        if (!link.isActive()) {
            throw new InvalidLinkException("Link with id " + id + " is already invalidated");
        }

        return new MetricsDTO(link.getLinkId(), link.getCount());
    }

    @Override
    public InvalidatedDTO invalidate(int id, String password) {
        Optional<Link> optionalLink = linkRepository.getById(id);

        if (optionalLink.isEmpty()) {
            throw new LinkNotFoundException("Link with id " + id + " not found.");
        }

        Link linkToInvalidate = optionalLink.get();

        if (!linkToInvalidate.getPassword().equals(password)) {
            throw new InvalidPasswordException("Incorrect password");
        }

        if (!linkToInvalidate.isActive()) {
            throw new InvalidLinkException("Link with id " + id + " is invalid.");
        }

        linkToInvalidate.setActive(false);

        linkRepository.upsert(linkToInvalidate, linkToInvalidate.getLinkId());

        return new InvalidatedDTO(linkToInvalidate.getLinkId(), true, linkToInvalidate.getUrl());
    }

    @Override
    public LinkDTO getById(int id, String password){
        Optional<Link> link = linkRepository.getById(id);
        if(link.isEmpty()) { throw new LinkNotFoundException("Link with id " + id + " not found.");}

        if (!link.get().getPassword().equals(password)) {
            throw new InvalidPasswordException("Incorrect password");
        }

        if(!link.get().isActive()){throw new InvalidLinkException("Link with id " + id + " is invalid.");}

        return new LinkDTO(link.get().getUrl(), link.get().getPassword());
    }
}
