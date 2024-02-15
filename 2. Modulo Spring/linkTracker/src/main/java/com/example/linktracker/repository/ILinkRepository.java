package com.example.linktracker.repository;

import com.example.linktracker.dto.request.LinkIdMetricsDTO;
import com.example.linktracker.dto.request.RedirectRequestDTO;
import com.example.linktracker.entity.Link;

public interface ILinkRepository {

    Link getById(int id);
    int save(Link link);
    boolean invalidateLink(int linkId);
    Integer getMetrics(LinkIdMetricsDTO link);
    void incrementCounter(int linkId);


}
