package com.linktraker.ejercicio2.service;

import java.util.List;

import com.linktraker.ejercicio2.dto.LinkDto;
import com.linktraker.ejercicio2.dto.LinkIdDto;
import com.linktraker.ejercicio2.dto.LinkUrlDto;

public interface ILinkService {

    public List<LinkDto> getLinks();

    public LinkIdDto postLink(LinkUrlDto linkUrlDto);

    public LinkIdDto putLink(Integer linkIdDto);
}
