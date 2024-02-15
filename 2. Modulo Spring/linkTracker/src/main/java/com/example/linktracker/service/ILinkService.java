package com.example.linktracker.service;

import com.example.linktracker.dto.request.LinkIdMetricsDTO;
import com.example.linktracker.dto.request.LinkRequestWithPassword;
import com.example.linktracker.dto.response.LinkIdResponseDTO;
import com.example.linktracker.dto.response.LinkMetricsDTO;
import com.example.linktracker.dto.response.RedirectResponseDTO;
import com.example.linktracker.dto.request.RedirectRequestDTO;
import com.example.linktracker.dto.response.ResponseDTO;

public interface ILinkService {
    LinkIdResponseDTO createLink(LinkRequestWithPassword linkDto);
    RedirectResponseDTO redirect(RedirectRequestDTO linkIdDto);
    LinkMetricsDTO getMetrics(LinkIdMetricsDTO metricReqDto);
    ResponseDTO invalidateLink(int linkId);
}
