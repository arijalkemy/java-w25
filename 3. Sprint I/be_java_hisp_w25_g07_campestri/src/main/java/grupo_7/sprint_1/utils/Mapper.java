package grupo_7.sprint_1.utils;

import grupo_7.sprint_1.dtos.*;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Product;
import grupo_7.sprint_1.entity.Seller;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    public static PostDto convertPostToPostDto(Post post) {
        return new PostDto(
                convertProductToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getDate()
        );
    }

    public static PromoPostDto convertPromoPostToPromoPostDto(Post post) {
        return new PromoPostDto(
                convertProductToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getDate(),
                post.getHas_promo(),
                post.getDiscount()
        );
    }

    public static ProductDto convertProductToProductDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public static Post convertPostDtoToPost(AddPostDto newPost) {
        return new Post(
                convertProductDtoToProduct(newPost.product()),
                newPost.category(),
                newPost.price(),
                newPost.date()
        );
    }

    public static Post convertPromoPostDtoToPost(AddPromoPostDto newPost) {
        return new Post(
                convertProductDtoToProduct(newPost.product()),
                newPost.category(),
                newPost.price(),
                newPost.date(),
                newPost.hasPromo(),
                newPost.discount()
        );
    }

    private static Product convertProductDtoToProduct(ProductDto product) {
        return new Product(
                product.productId(),
                product.productName(),
                product.type(),
                product.brand(),
                product.color(),
                product.notes()
        );
    }

    public static BuyerDto convertBuyerToBuyerDto(Buyer buyer) {
        return new BuyerDto(
                buyer.getUserId(),
                buyer.getUserName(),
                buyer.getFollowed().stream().map(Mapper::convertSellerToSellerDTOlist).toList()
        );
    }

    public static SellerListDto convertSellerToSellerDTOlist(Seller seller) {
        return new SellerListDto(
                seller.getUserId(),
                seller.getUserName()
        );
    }

    public static SellerDTO convertSellerToSellerDTO(Seller seller, int cantidadDeSeguidores) {
        return new SellerDTO(
                seller.getUserId(),
                seller.getUserName(),
                cantidadDeSeguidores
        );
    }

    public static BuyerDtoRequisito3 convertListToDto(Buyer buyerList) {
        return new BuyerDtoRequisito3(buyerList.getUserId(), buyerList.getUserName());
    }

}

