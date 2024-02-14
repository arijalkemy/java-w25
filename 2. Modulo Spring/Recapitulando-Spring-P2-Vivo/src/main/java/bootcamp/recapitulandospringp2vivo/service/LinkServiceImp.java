package bootcamp.recapitulandospringp2vivo.service;

import bootcamp.recapitulandospringp2vivo.dto.request.RequestCreateLinkDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.LinkResponseDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.MetricsResponseDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.ResponseCreateLinkDTO;
import bootcamp.recapitulandospringp2vivo.entity.Link;
import bootcamp.recapitulandospringp2vivo.exception.IncorrectPasswordException;
import bootcamp.recapitulandospringp2vivo.exception.InvalidLinkException;
import bootcamp.recapitulandospringp2vivo.exception.LinkNotFoundException;
import bootcamp.recapitulandospringp2vivo.repository.ILinkRepository;
import bootcamp.recapitulandospringp2vivo.util.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImp implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public ResponseCreateLinkDTO createLink(RequestCreateLinkDTO requestDto) {
        return ResponseCreateLinkDTO.builder()
                .linkId(linkRepository.createLink(requestDto))
                .build();
    }

    @Override
    public String redirect(Integer linkId, String password) {
        Link link = checkIfLinkExistsAndGet(linkId);
        if (!link.getPassword().equals(password))
            throw new IncorrectPasswordException();
        if (!link.isValid())
            throw new InvalidLinkException();
        linkRepository.visitedInc(linkId);
        return link.getUrl();
    }

    @Override
    public MetricsResponseDTO getMetricsById(Integer linkId) {
        Link link = checkIfLinkExistsAndGet(linkId);
        Integer timesVisited = link.getTimesVisited();
        return MetricsResponseDTO.builder().timesRedirected(timesVisited).build();
    }

    @Override
    public void invalidateLink(Integer linkId) {
        checkIfLinkExistsAndGet(linkId);
        linkRepository.invalidateLink(linkId);
    }
    @Override
    public LinkResponseDTO getById(Integer linkId){
        Link link = checkIfLinkExistsAndGet(linkId);
        return LinkMapper.createLinkResponseDTO(link);
    }

    private Link checkIfLinkExistsAndGet(Integer linkId){
        Link link = linkRepository.getById(linkId);
        if (link == null)
            throw new LinkNotFoundException(linkId);
        return link;
    }

}
