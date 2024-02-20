package com.link.link.service;

import com.link.link.dto.request.CreateLinkDTO;
import com.link.link.dto.response.CreatedLinkIdDTO;
import com.link.link.dto.response.LinkMetricsDTO;
import com.link.link.dto.response.RedirectLinkDTO;
import com.link.link.entity.Link;
import com.link.link.exception.IncorrectPasswordException;
import com.link.link.exception.InvalidLinkException;
import com.link.link.exception.LinkAlreadyExistsException;
import com.link.link.exception.NotFoundException;
import com.link.link.repository.ILinkRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkServiceImpl implements ILinkService {
    private final ILinkRepository linkRepository;

    public LinkServiceImpl(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public CreatedLinkIdDTO createLink(CreateLinkDTO link) {
        if (this.invalidLink(link.getLink())) {
            throw new InvalidLinkException("Link is in invalid list");
        }
        Link linkToSave;
        if (link.getPassword() == null) {
            linkToSave = new Link(link.getLink(), 0);
        } else {
            linkToSave = new Link(link.getLink(), link.getPassword(), 0);
        }
        return new CreatedLinkIdDTO(this.linkRepository.addLink(linkToSave));
    }

    @Override
    public RedirectLinkDTO getLinkById(int id, String password) {
        Link link = this.linkRepository.getLinkById(id);
        if (link == null) {
            throw new NotFoundException("Link not found");
        }
        if (link.getPassword() != null) {
            if (!link.getPassword().equals(password)) {
                throw new IncorrectPasswordException("Incorrect password");
            }
        }
        return new RedirectLinkDTO(new RedirectView(this.linkRepository.getLinkById(id).getLink()));
    }

    @Override
    public LinkMetricsDTO getLinkMetrics(int id) {
        return new LinkMetricsDTO(this.linkRepository.getLinkById(id).getCalls());
    }

    @Override
    public void addInvalidLink(int id) {
        if (this.linkRepository.getLinkById(id) == null) {
            throw new NotFoundException("Link not found");
        }
        this.linkRepository.addInvalidLink(id);
    }

    private boolean invalidLink(String link) {
        for (Link linkToValidate : this.linkRepository.getAllInvalidLinks()) {
            if (linkToValidate.getLink().equals(link)) {
                return true;
            }
        }
        return false;
    }
}
