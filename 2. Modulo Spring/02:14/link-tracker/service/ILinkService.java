package com.spring.linktracker.service;

import java.util.List;

import com.spring.linktracker.dto.LinkDto;
import com.spring.linktracker.dto.LinkIdDto;
import com.spring.linktracker.dto.LinkRedirectsDto;
import com.spring.linktracker.dto.LinkUrlDto;
import com.spring.linktracker.dto.req.LinkReqDto;

public interface ILinkService {

    public List<LinkDto> getLinks();

    public LinkIdDto postLink(LinkUrlDto linkUrlDto);

    public LinkIdDto putLink(Integer linkIdDto);

    public LinkRedirectsDto getMetrics(LinkReqDto id);
}
