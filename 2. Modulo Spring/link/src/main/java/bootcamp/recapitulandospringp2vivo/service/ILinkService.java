package bootcamp.recapitulandospringp2vivo.service;

import bootcamp.recapitulandospringp2vivo.dto.request.RequestCreateLinkDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.LinkResponseDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.MetricsResponseDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.ResponseCreateLinkDTO;

public interface ILinkService {

    ResponseCreateLinkDTO createLink(RequestCreateLinkDTO requestDto);
    String redirect(Integer linkId, String password);
    MetricsResponseDTO getMetricsById(Integer linkId);
    void invalidateLink(Integer linkId);

    LinkResponseDTO getById(Integer linkId);

}
