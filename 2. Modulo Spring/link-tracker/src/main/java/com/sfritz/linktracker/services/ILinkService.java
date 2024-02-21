package com.sfritz.linktracker.services;

import com.sfritz.linktracker.dtos.LinkRequestDto;
import com.sfritz.linktracker.dtos.LinkResponseDto;

public interface ILinkService {

    LinkResponseDto createLink(LinkRequestDto requestDto);
}
