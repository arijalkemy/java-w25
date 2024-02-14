package bootcamp.recapitulandospringp2vivo.repository;

import bootcamp.recapitulandospringp2vivo.dto.request.RequestCreateLinkDTO;
import bootcamp.recapitulandospringp2vivo.entity.Link;
import bootcamp.recapitulandospringp2vivo.util.LinkMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoyImp implements ILinkRepository {

    private Map<Integer, Link> links = new HashMap<>();
    private Integer index = 0;

    @Override
    public Integer createLink(RequestCreateLinkDTO linkDto) {
        Link link = LinkMapper.createLink(linkDto, index);
        index++;
        links.put(link.getLinkId(), link);
        return link.getLinkId();
    }

    @Override
    public void invalidateLink(Integer linkId) {
        links.get(linkId).setValid(false);
    }

    @Override
    public Link getById(Integer linkId) {
        return links.get(linkId);
    }

    @Override
    public void visitedInc(Integer linkdId){
        links.get(linkdId).setTimesVisited(links.get(linkdId).getTimesVisited()+1);
    }

}
