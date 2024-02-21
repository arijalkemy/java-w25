package link_tracker.repository;

import link_tracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository{
    List<Link> links = new ArrayList<>();
    private long id = 0L;


    public Optional<Link> getById(Long id){
        return links.stream().filter(l->l.getId().equals(id)).findFirst();
    }

    public Link save(Link link){
        link.setId(this.id++);
        links.add(link);
        return link;
    }
}
