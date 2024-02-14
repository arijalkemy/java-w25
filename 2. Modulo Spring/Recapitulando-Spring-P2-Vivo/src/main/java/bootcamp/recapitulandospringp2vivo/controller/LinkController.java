package bootcamp.recapitulandospringp2vivo.controller;

import bootcamp.recapitulandospringp2vivo.dto.request.RequestCreateLinkDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.InvalidateLinkResponseDto;
import bootcamp.recapitulandospringp2vivo.dto.response.MetricsResponseDTO;
import bootcamp.recapitulandospringp2vivo.dto.response.ResponseCreateLinkDTO;
import bootcamp.recapitulandospringp2vivo.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("link/create")
    public ResponseEntity<ResponseCreateLinkDTO> createLink(@RequestBody RequestCreateLinkDTO requestDto){
        ResponseCreateLinkDTO response = linkService.createLink(requestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("link/{linkId}")
    public void redirect(
            @PathVariable Integer linkId,
            @RequestParam String password,
            HttpServletResponse httpServletResponse){
        String url = linkService.redirect(linkId, password);
        httpServletResponse.setHeader("Location", url);
        httpServletResponse.setStatus(302);
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<MetricsResponseDTO> getMetricsById(@PathVariable Integer linkId) {
        MetricsResponseDTO response = linkService.getMetricsById(linkId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("invalidate/{linkId}")
    public ResponseEntity<InvalidateLinkResponseDto> invalidateLink(@PathVariable Integer linkId) {
        linkService.invalidateLink(linkId);
        InvalidateLinkResponseDto response = InvalidateLinkResponseDto.builder().linkId(linkId).build();
        return ResponseEntity.ok(response);
    }

}
