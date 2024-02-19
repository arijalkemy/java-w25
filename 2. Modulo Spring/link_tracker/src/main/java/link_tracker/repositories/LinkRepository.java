package link_tracker.repositories;

import link_tracker.entities.Link;

public interface LinkRepository {


    public Link getLinkById(int linkId);
    public Link createLink(String stringURL);
    public int getLinkStatistics(int linkId);

    public void invalidateLink(int linkId);

}
