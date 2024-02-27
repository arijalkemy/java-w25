package com.example.link_tracker.service;

import com.example.link_tracker.entity.Link;
import com.example.link_tracker.repository.ILinkRepository;
import com.example.link_tracker.repository.LinkRepositoryImp;
import org.springframework.stereotype.Service;

@Service
public class LinkServicesImp implements ILinkServices{

    ILinkRepository linkRepository;

    public LinkServicesImp(LinkRepositoryImp linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link createLink(String url) {
        return linkRepository.createLink(url);
    }




}
