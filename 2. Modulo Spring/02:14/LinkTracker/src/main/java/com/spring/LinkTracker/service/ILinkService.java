package com.spring.LinkTracker.service;

import java.util.List;

import com.spring.LinkTracker.dto.LinkDto;
import com.spring.LinkTracker.dto.LinkIdDto;
import com.spring.LinkTracker.dto.LinkRedirectsDto;
import com.spring.LinkTracker.dto.LinkUrlDto;
import com.spring.LinkTracker.dto.req.LinkReqDto;

public interface ILinkService {

    public List<LinkDto> getLinks();

    public LinkIdDto postLink(LinkUrlDto linkUrlDto);

    public LinkIdDto putLink(Integer linkIdDto);

    public LinkRedirectsDto getMetrics(LinkReqDto id);
}
