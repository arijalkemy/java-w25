package link_tracker.service;

import link_tracker.dto.LinkResponseDTO;

public interface LinkService {

    public LinkResponseDTO createLink(String stringURL);
    public void redirectLink();
    public void invalidateLink();
    public void linkStatistics();
}
