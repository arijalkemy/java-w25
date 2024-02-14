package bootcamp.recapitulandospringp2vivo.util;

import bootcamp.recapitulandospringp2vivo.dto.request.RequestCreateLinkDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.LinkResponseDTO;
import bootcamp.recapitulandospringp2vivo.entity.Link;

public class LinkMapper {

    public static Link createLink(RequestCreateLinkDTO linkDto, Integer id) {
        return Link.builder()
                .linkId(id)
                .url(linkDto.getUrl())
                .password(linkDto.getPassword())
                .build();
    }

    public static LinkResponseDTO createLinkResponseDTO(Link link) {
        return LinkResponseDTO.builder()
                .linkId(link.getLinkId())
                .url(link.getUrl())
                .password(link.getPassword())
                .timesVisited(link.getTimesVisited())
                .build();
    }

}
