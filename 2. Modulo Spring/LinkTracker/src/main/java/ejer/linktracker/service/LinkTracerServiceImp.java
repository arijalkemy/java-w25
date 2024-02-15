package ejer.linktracker.service;

import ejer.linktracker.DTO.request.LinkCreationDTO;
import ejer.linktracker.DTO.response.LinkDTO;
import ejer.linktracker.DTO.response.LinkEstadisticasDto;
import ejer.linktracker.entity.Link;
import ejer.linktracker.exception.LinkNotAvailableException;
import ejer.linktracker.exception.NotFoundException;
import ejer.linktracker.repository.ILinkTracerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkTracerServiceImp implements  ILinkTracerService{

    @Autowired
    private final ILinkTracerRepository linkTracerRepository;

    public LinkTracerServiceImp(ILinkTracerRepository linkTracerRepository) {
        this.linkTracerRepository = linkTracerRepository;
    }

    @Override
    public void addLink(LinkCreationDTO linkCreationDTO) {
        linkTracerRepository.addLink(new Link(
                linkCreationDTO.getId(),
                linkCreationDTO.getUrl(),
                0,
                linkCreationDTO.getContrasena(),
                true
        ));
    }

    @Override
    public LinkDTO getById(int id) {
        Link link = linkTracerRepository.getById(id);
        if (link == null) {
            throw new NotFoundException(String.format("No se encontro el link con ID %d", id));
        }
        return new LinkDTO(
            link.getId(),
            link.getUrl(),
            link.getContador(),
            link.getContrasena(),
            link.getEsValido()
        );
    }

    @Override
    public List<LinkDTO> getAll() {
        List<Link> linksList = linkTracerRepository.getAll();
        List<LinkDTO> linksResponse = null;
        if (linksList != null) {
            for (Link link : linksList) {
                linksResponse.add(new LinkDTO(
                    link.getId(),
                    link.getUrl(),
                    link.getContador(),
                    link.getContrasena(),
                    link.getEsValido()
                ));
            }
        }
        return linksResponse;
    }

    @Override
    public LinkEstadisticasDto getMetrics(int id) {
        Link link = linkTracerRepository.getById(id);
        if (link == null) {
            throw new NotFoundException(String.format("No se encontro el link con ID %d", id));
        }
        return new LinkEstadisticasDto(
                link.getId(),
                link.getContador()
        );
    }

    @Override
    public void invalidateLink(int id) {
        linkTracerRepository.updateEsValido(id);
    }

    @Override
    public String redirect(int id, String contrasena) {
        Link link = linkTracerRepository.getById(id);
        linkTracerRepository.updateRedirects(id);
        if (link.getEsValido() && link.getContrasena().equals(contrasena)) {

            return link.getUrl();
        }

        throw new LinkNotAvailableException("El link no se encuentra habilitado o la contra esta mal");
    }
}
