package link_tracker.repositories;

import link_tracker.entities.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements LinkRepository{

    private List<Link> linkList = new ArrayList<>();


    @Override
    public Link getLinkById(int linkId) {
        return null;
    }

    @Override
    public Link createLink(String stringURL) {
        int newId = linkList.size() + 1;
        Link newLink = new Link(stringURL, newId);
        linkList.add(newLink);
        return newLink;
    }

    @Override
    public int getLinkStatistics(int linkId) {
        return 0;
    }

    @Override
    public void invalidateLink(int linkId) {

    }
}
