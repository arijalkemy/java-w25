package org.example.linktracker.dto.request;

public record LinkDtoRequest(
        long id,
        String password,
        String link
) {
}
