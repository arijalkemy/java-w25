package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoCountDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostListResponseDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.SellerPostDTO;
import java.util.List;

public interface IPostService {
    PostDTO addPost(PostDTO postDTO);
    PromoPostDTO addPromoPost(PromoPostDTO promoPostDTO);
    List<PostDTO> getPosts(Integer idUsuario);
    SellerPostDTO getPostPerSeller(Integer id, String order);
    PromoCountDTO getPromoProductsCount(Integer idUsuario);
    PromoPostListResponseDTO getPromoPostsList(Integer idUsuario, String order);

}
