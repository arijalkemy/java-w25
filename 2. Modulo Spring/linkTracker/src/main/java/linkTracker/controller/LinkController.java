package linkTracker.controller;

import linkTracker.dto.request.LinkDTO;
import linkTracker.dto.response.CreatedLinkDTO;
import linkTracker.dto.response.InvalidatedDTO;
import linkTracker.dto.response.MetricsDTO;
import linkTracker.service.ILinkService;
import linkTracker.service.LinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class LinkController {

    private ILinkService linkService;

    @Autowired
    public LinkController(LinkServiceImpl linkService){
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<CreatedLinkDTO> createLink (@RequestBody LinkDTO link,
                                                      @RequestParam String password){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(linkService.create(link));
    }

    @GetMapping("/link/{linkId}")
    public void redirectLink(@PathVariable Integer linkId,
                             @RequestParam String password,
                             HttpServletResponse httpServletResponse) throws IOException {
        LinkDTO link = linkService.getById(linkId, password);
        httpServletResponse.sendRedirect(link.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<MetricsDTO> getMetrics(@PathVariable int linkId,
                                                 @RequestParam String password){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(linkService.getMetrics(linkId, password));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<InvalidatedDTO> invalidateLink(@PathVariable int linkId,
                                                         @RequestParam String password){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(linkService.invalidate(linkId, password));
    }

}
