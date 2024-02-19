package link_tracker.controller;


import jakarta.servlet.http.HttpServletResponse;
import link_tracker.dto.LinkResponseDTO;
import link_tracker.dto.RequestDTO;
import link_tracker.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class LinkController {

    private final LinkService linkService;
    @PostMapping()
    public ResponseEntity<?> createLink(@RequestBody RequestDTO request){
        System.out.println("Agregarndo nueva URL: " + request.getNewURL());
        System.out.println("Ingresando por aqui");
        LinkResponseDTO myDTO = linkService.createLink(request.getNewURL());
        System.out.println(myDTO.getLinkId());
        return new ResponseEntity<>(myDTO, HttpStatus.CREATED);
    }

    @GetMapping("redirect/{maskedUrl}")
    public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
        LinkResponseDTO link = linkService.redirect(linkId);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping("/redirectWithRedirectPrefix")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/redirect_test", model);
    }

    @GetMapping("/redirect_test")
    public ResponseEntity<?> redirectTest() {
        System.out.println("Prueba de redirección relativa exitosa");
        return new ResponseEntity<>("Redirección dentro de dominio exitosa", HttpStatus.OK);
    }

}
