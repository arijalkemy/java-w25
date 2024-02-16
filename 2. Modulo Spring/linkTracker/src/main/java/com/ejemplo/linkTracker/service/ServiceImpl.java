package com.ejemplo.linkTracker.service;

import com.ejemplo.linkTracker.dto.LinkResDTO;
import com.ejemplo.linkTracker.dto.LinkRqDTO;
import com.ejemplo.linkTracker.exception.BadRequestException;
import com.ejemplo.linkTracker.exception.NotFoundException;
import com.ejemplo.linkTracker.exception.ObjectDuplicateException;
import com.ejemplo.linkTracker.model.Link;
import com.ejemplo.linkTracker.repository.ILinkRepository;
import com.ejemplo.linkTracker.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService{

    private int count = 0;
    ILinkRepository repository;

    public ServiceImpl(ILinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkResDTO createLink(LinkRqDTO linkRqDTO) {

        Link link = Mapper.converToLink(linkRqDTO);
        if(repository.getMap().containsValue(link)) throw new ObjectDuplicateException("Elemento ya existe");
        count++;
        return new LinkResDTO(repository.create(link, count));
    }

    @Override
    public String getLink(int id, String password) {

        Link link = repository.getLink(id);
        if (!link.isValid()) throw new NotFoundException("Elemento invalido");
        if (!link.getPassword().equals(password)) throw new BadRequestException("Password invalida");
        int countVisit = link.getCount() + 1;
        link.setCount(countVisit);
        repository.removeLink(id);
        repository.create(link, id);
        return link.getLink();
    }

    @Override
    public LinkResDTO getMetrics(int id) {
        int countVisit = repository.getLink(id).getCount();
        return new LinkResDTO(null, countVisit);
    }

    @Override
    public LinkResDTO invalidLink(int id) {
        Link link = repository.getLink(id);
        link.setValid(false);
        repository.removeLink(id);
        repository.create(link, id);

        return new LinkResDTO("Invalidacion completada");
    }
}
