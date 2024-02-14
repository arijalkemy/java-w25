package bootcamp.recapitulandospringp2vivo.repository;

import bootcamp.recapitulandospringp2vivo.dto.request.RequestCreateLinkDTO;
import bootcamp.recapitulandospringp2vivo.entity.Link;

public interface ILinkRepository {

    Integer createLink(RequestCreateLinkDTO linkDto);

    void invalidateLink(Integer linkId);

    Link getById(Integer linkid);

    void visitedInc(Integer linkid);
}
