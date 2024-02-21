package link_tracker.repository;

import link_tracker.entity.Link;

import java.util.Optional;

public interface ILinkTrackerRepository {
    Optional<Link> getById(Long id);

    Link save(Link link);
}
