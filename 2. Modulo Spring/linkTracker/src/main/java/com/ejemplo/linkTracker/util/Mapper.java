package com.ejemplo.linkTracker.util;

import com.ejemplo.linkTracker.dto.LinkRqDTO;
import com.ejemplo.linkTracker.model.Link;

public class Mapper {

    public static Link converToLink(LinkRqDTO linkRqDTO){

        return new Link(linkRqDTO.getLink(), 0, true, linkRqDTO.getPassword());
    }
}
