package grupo_7.sprint_1.utils;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.ProductDto;
import grupo_7.sprint_1.dtos.SellerListDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Product;
import grupo_7.sprint_1.entity.Seller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockBuilder {

    public static List<Seller> mockSellers() {

        List<Seller> sellers = new ArrayList<>();
        Seller seller = new Seller();

        seller.setUserId(1);
        seller.setFollowers(List.of(new Buyer()));
        seller.setPosts(List.of(new Post(new Product(1), 1, 100.0, LocalDate.now().minusDays(2)),
                new Post(new Product(2), 2, 200.0, LocalDate.now().minusDays(3)),
                new Post(new Product(3), 3, 300.0, LocalDate.now().minusDays(4))));

        sellers.add(seller);
        return sellers;
    }



    public static Buyer mockBuyer() {

        Seller seller2 = new Seller();
        seller2.setUserId(2);
        seller2.setUserName("Seller_2");

        Seller seller1 = new Seller();
        seller1.setUserId(1);
        seller1.setUserName("Seller_1");

        Seller seller3 = new Seller();
        seller3.setUserId(3);
        seller3.setUserName("Seller_3");

        return new Buyer(1, "Buyer_1", List.of(seller1, seller2, seller3));
    }

    public static BuyerDto mockBuyerAscDto() {
        return new BuyerDto(
                1,
                "Buyer_1",
                List.of(
                        new SellerListDto(1, "Seller_1"),
                        new SellerListDto(2, "Seller_2"),
                        new SellerListDto(3, "Seller_3")
                )
        );

    }

    public static BuyerDto mockBuyerDescDto() {
        return new BuyerDto(
                1,
                "Buyer_1",
                List.of(
                        new SellerListDto(3, "Seller_3"),
                        new SellerListDto(2, "Seller_2"),
                        new SellerListDto(1, "Seller_1")
                )
        );
    }

    public static Buyer mockBuyerForSeller() {
        Seller seller = new Seller();
        seller.setUserId(1);
        return new Buyer(1, "Buyer_1", List.of(seller));
    }

    public static Seller mockSeller() {

        Seller seller = new Seller();

        seller.setUserId(1);
        seller.setFollowers(
                List.of(new Buyer())
        );
        seller.setPosts(
                List.of(
                        new Post(new Product(1), 1, 100.0, LocalDate.now().minusDays(2)),
                        new Post(new Product(2), 2, 200.0, LocalDate.now().minusDays(3)),
                        new Post(new Product(3), 3, 300.0, LocalDate.now().minusDays(4))
                )
        );

        return seller;
    }

    public static List<PostDto> mockPostDtos() {
        return List.of(
                new PostDto(mockProductDto(1), 1, 100.0, LocalDate.now().minusDays(2)),
                new PostDto(mockProductDto(2), 2, 200.0, LocalDate.now().minusDays(3)),
                new PostDto(mockProductDto(3), 3, 300.0, LocalDate.now().minusDays(4))
        );
    }

    public static List<PostDto> mockPostDtosPlusDays() {
        return List.of(
                new PostDto(mockProductDto(1), 1, 100.0, LocalDate.now().minusDays(20)),
                new PostDto(mockProductDto(2), 2, 200.0, LocalDate.now().minusDays(30)),
                new PostDto(mockProductDto(3), 3, 300.0, LocalDate.now().minusDays(40))
        );
    }

    public static ProductDto mockProductDto(Integer id) {
        return new ProductDto(
                id,
                null,
                null,
                null,
                null,
                null
        );
    }

}
