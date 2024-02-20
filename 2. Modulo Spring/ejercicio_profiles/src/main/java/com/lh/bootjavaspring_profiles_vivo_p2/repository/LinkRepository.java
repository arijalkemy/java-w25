package com.lh.bootjavaspring_profiles_vivo_p2.repository;

import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPost;
import com.lh.bootjavaspring_profiles_vivo_p2.dto.request.LinkDTOPostInvalidate;
import com.lh.bootjavaspring_profiles_vivo_p2.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {

    private List<Link> links = new ArrayList<>();
    private Long count = 1L;

    @Override
    public Link post(LinkDTOPost url) {

        Link newLink = new Link(
                count,
                url.getUrl(),
                "https://maskedurl" + count + ".com",
                0L,
                true,
                url.getPassword()
        );

        links.add(newLink);
        count++;
        return newLink;
    }

    @Override
    public Optional<Link> postInvalidate(LinkDTOPostInvalidate id) {
        Optional<Link> optionalLink = getById(id.getId());

        if (optionalLink.isPresent()) {
            Link foundLink = optionalLink.get();
            foundLink.setValid(false);
            return Optional.of(foundLink);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Link> getById(Long id) {
        return links.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Link> getByUrl(String url) {
        return links.stream().filter(b -> b.getUrl().equals(url)).findFirst();
    }
}
