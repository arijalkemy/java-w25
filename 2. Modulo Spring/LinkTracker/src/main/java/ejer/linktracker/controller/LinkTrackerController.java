package ejer.linktracker.controller;

import ejer.linktracker.DTO.request.LinkCreationDTO;
import ejer.linktracker.DTO.response.LinkDTO;
import ejer.linktracker.DTO.response.LinkEstadisticasDto;
import ejer.linktracker.DTO.response.LinkIdDto;
import ejer.linktracker.entity.Link;
import ejer.linktracker.repository.ILinkTracerRepository;
import ejer.linktracker.service.ILinkTracerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class LinkTrackerController {
    private final ILinkTracerService linkTracerService;

    public LinkTrackerController(ILinkTracerService linkTracerService){
        this.linkTracerService = linkTracerService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLink (@RequestBody LinkCreationDTO linkCreationDTO){
        linkTracerService.addLink(linkCreationDTO);
        return ResponseEntity.ok(new LinkIdDto(linkCreationDTO.getId()));
    }

    @GetMapping("/link/{linkID}")
    public RedirectView getRedirect(@PathVariable Integer linkID, @RequestParam String contrasena){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://" + linkTracerService.redirect(linkID,contrasena));

        return redirectView;
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<LinkEstadisticasDto> getMetricsByLink (@PathVariable Integer linkID){
        return ResponseEntity.ok(linkTracerService.getMetrics(linkID));
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<?> invalidateLink (@PathVariable Integer linkID){
        Optional<LinkDTO> linkOpt = Optional.ofNullable(linkTracerService.getById(linkID));
        if(linkOpt.isPresent()){
            LinkDTO link = linkOpt.get();
            linkTracerService.invalidateLink(link.getId());
            return ResponseEntity.ok().body("invalidado link con id"+ linkID);
        }

        return null;
    }
}
