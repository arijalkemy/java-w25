package link_tracker.controller;

import link_tracker.dto.request.CreateLinkDTO;
import link_tracker.dto.LinkDTO;
import link_tracker.dto.response.MetricsDTO;
import link_tracker.dto.response.SuccessDTO;
import link_tracker.entity.Link;
import link_tracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {
    @Autowired
    ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<LinkDTO> create(@RequestBody CreateLinkDTO createLinkDTO){
        LinkDTO linkId = this.linkTrackerService.createLink(createLinkDTO);
        return new ResponseEntity<>(linkId, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<SuccessDTO> invalidate(@PathVariable Long linkId){
        SuccessDTO successMessage = this.linkTrackerService.invalidateLink(linkId);
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView Redirect(@PathVariable Long linkId){
        Link link = this.linkTrackerService.getLink(linkId);
        return new RedirectView(link.getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<MetricsDTO> metricsLink(@PathVariable Long linkId){
        return new ResponseEntity<>(
            this.linkTrackerService.getLinkMetrics(linkId),
            HttpStatus.OK
        );
    }
}
