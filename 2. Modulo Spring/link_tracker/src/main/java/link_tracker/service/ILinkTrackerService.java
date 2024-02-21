package link_tracker.service;

import link_tracker.dto.request.CreateLinkDTO;
import link_tracker.dto.LinkDTO;
import link_tracker.dto.response.MetricsDTO;
import link_tracker.dto.response.SuccessDTO;
import link_tracker.entity.Link;

public interface ILinkTrackerService {
    Link getLink(Long id);

    LinkDTO createLink(CreateLinkDTO link);

    MetricsDTO getLinkMetrics(Long linkId);

    SuccessDTO invalidateLink(Long linkId);


}
