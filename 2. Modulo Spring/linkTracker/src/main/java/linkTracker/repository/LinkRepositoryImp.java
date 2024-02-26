package linkTracker.repository;

import linkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LinkRepositoryImp implements ILinkRepository {
    private Map<Integer, Link> links;

    public LinkRepositoryImp() {

        this.links = new HashMap<>();
    }

    @Override
    public Optional<Link> getById(int id) {
        if (!this.links.containsKey(id)) {
            return Optional.empty();
        }

        return Optional.of(this.links.get(id));
    }

    @Override
    public int upsert(Link link) {
        int linkId = this.links.size();
        link.setLinkId(linkId);
        this.links.put(linkId, link);

        return linkId;
    }

    @Override
    public int upsert(Link link, int linkId) {
        this.links.put(linkId, link);

        return linkId;
    }
}
