package linkTracker.repository;

import linkTracker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Optional<Link> getById(int id);
    int upsert(Link link);
    int upsert(Link link, int linkId);

}
