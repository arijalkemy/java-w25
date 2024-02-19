package link_tracker.service;

import link_tracker.dto.LinkResponseDTO;
import link_tracker.entities.Link;
import link_tracker.repositories.LinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    @Override
    public LinkResponseDTO createLink(String stringURL) {

        Link newLink = linkRepository.createLink(stringURL);
        // Convertimos a DTO

        LinkResponseDTO myStuff = new LinkResponseDTO(newLink.getLinkId());
        System.out.println();

        return new LinkResponseDTO(newLink.getLinkId());
    }

    @Override
    public void redirectLink() {

    }

    @Override
    public void invalidateLink() {

    }

    @Override
    public void linkStatistics() {

    }
}
