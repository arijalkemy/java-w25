package org.blog.utils;

import org.blog.dto.response.EntradaBlogDTO;
import org.blog.model.EntradaBlog;

public final class EntradaMapper {

    public static EntradaBlogDTO toDTO(EntradaBlog entry) {
        return new EntradaBlogDTO(
                entry.getId(),
                entry.getTitle(),
                entry.getAuthor(),
                entry.getPublicationDate()
        );
    }

    public static EntradaBlog fromDTO(EntradaBlogDTO entry) {
        return new EntradaBlog(
                entry.getId(),
                entry.getTitle(),
                entry.getAuthor(),
                entry.getPublicationDate()
        );
    }

}
