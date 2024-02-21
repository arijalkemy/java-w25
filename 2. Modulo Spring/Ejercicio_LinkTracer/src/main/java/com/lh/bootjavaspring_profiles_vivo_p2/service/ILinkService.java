package com.lh.bootjavaspring_profiles_vivo_p2.service;

import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkAuthDTO;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPost;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPostInvalidate;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.response.LinkDTOGetStats;
import com.lh.bootjavaspring_profiles_vivo_p2.model.Link;

public interface ILinkService {
    LinkDTOGetStats post(LinkDTOPost url);
    LinkDTOGetStats postInvalidate(LinkDTOPostInvalidate id);
    LinkDTOGetStats getStatsLink(Long id);
    LinkDTOGetStats getLinkRedirect(LinkAuthDTO linkAuthDTO);
}
