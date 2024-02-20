package com.link.link.service;

import com.link.link.dto.request.CreateLinkDTO;
import com.link.link.dto.response.CreatedLinkIdDTO;
import com.link.link.dto.response.LinkMetricsDTO;
import com.link.link.dto.response.RedirectLinkDTO;

public interface ILinkService {
    CreatedLinkIdDTO createLink(CreateLinkDTO link);
    LinkMetricsDTO getLinkMetrics(int id);
    RedirectLinkDTO getLinkById(int id, String password);
    void addInvalidLink(int id);

}
