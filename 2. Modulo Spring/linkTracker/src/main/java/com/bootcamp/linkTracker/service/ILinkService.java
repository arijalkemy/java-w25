package com.bootcamp.linkTracker.service;

import com.bootcamp.linkTracker.dto.LinkDTO;
import com.bootcamp.linkTracker.dto.response.LinkResponseDTO;
import com.bootcamp.linkTracker.dto.response.ResponseDTO;
import com.bootcamp.linkTracker.dto.response.StatisticsDTO;

public interface ILinkService {
    ResponseDTO createLink(LinkDTO linkDTO);
    LinkResponseDTO redirectLink(Long linkId);
    StatisticsDTO getStatistics(Long linkID);
    void invalidateLink(Long linkID);
}
