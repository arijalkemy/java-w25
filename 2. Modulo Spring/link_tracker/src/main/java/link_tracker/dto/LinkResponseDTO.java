package link_tracker.dto;

import lombok.Data;

@Data
public class LinkResponseDTO {

    private int linkId;

    public LinkResponseDTO(int linkId) {
        this.linkId = linkId;
    }
}
