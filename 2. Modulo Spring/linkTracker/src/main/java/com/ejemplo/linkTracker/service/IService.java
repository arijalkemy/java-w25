package com.ejemplo.linkTracker.service;

import com.ejemplo.linkTracker.dto.LinkResDTO;
import com.ejemplo.linkTracker.dto.LinkRqDTO;

public interface IService {

    LinkResDTO createLink(LinkRqDTO linkRqDTO);

    String getLink(int id, String password);

    LinkResDTO getMetrics(int id);

    LinkResDTO invalidLink(int id);
}
