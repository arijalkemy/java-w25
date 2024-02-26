package linkTracker.service;

import linkTracker.dto.request.LinkDTO;
import linkTracker.dto.response.CreatedLinkDTO;
import linkTracker.dto.response.InvalidatedDTO;
import linkTracker.dto.response.MetricsDTO;
import linkTracker.entity.Link;

import java.util.Optional;

public interface ILinkService {
    CreatedLinkDTO create(LinkDTO link);
    MetricsDTO getMetrics(int id, String password);
    InvalidatedDTO invalidate(int id, String password);
    LinkDTO getById(int id, String password);
}
