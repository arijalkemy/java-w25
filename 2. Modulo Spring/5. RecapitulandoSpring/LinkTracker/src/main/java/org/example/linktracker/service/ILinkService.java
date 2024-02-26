package org.example.linktracker.service;

import org.example.linktracker.dto.LinkDto;
import org.example.linktracker.dto.request.LinkDtoRequest;
import org.example.linktracker.dto.response.LinkDtoMetricsResponse;
import org.example.linktracker.dto.response.LinkDtoResponse;
import org.example.linktracker.dto.response.MessageDto;

public interface ILinkService {

    public LinkDtoResponse createLink(LinkDtoRequest link);

    public LinkDto redirect(long linkId, String password);

    public LinkDtoMetricsResponse getLinkMetrics(long linkId);

    public MessageDto invalidateLink(long linkId);
}
