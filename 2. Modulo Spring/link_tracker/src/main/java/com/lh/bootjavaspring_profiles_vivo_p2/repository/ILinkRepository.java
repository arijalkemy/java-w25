package com.lh.bootjavaspring_profiles_vivo_p2.repository;

import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPost;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPostInvalidate;
import com.lh.bootjavaspring_profiles_vivo_p2.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link post(LinkDTOPost url);
    Optional<Link> postInvalidate(LinkDTOPostInvalidate id);
    Optional<Link> getById(Long id);
    Optional<Link> getByUrl(String url);
}
