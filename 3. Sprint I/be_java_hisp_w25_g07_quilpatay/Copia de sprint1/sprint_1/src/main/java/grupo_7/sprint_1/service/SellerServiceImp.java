package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dto.*;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.InvalidArgsException;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.repository.inter.IBuyerRepository;
import grupo_7.sprint_1.repository.inter.ISellerRepository;
import grupo_7.sprint_1.service.inter.ISellerService;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerServiceImp implements ISellerService {
    private final ISellerRepository sellerRepository;
    private final IBuyerRepository buyerRepository;

    public SellerServiceImp(ISellerRepository sellerRepository, IBuyerRepository buyerRepository) {
        this.sellerRepository = sellerRepository;
        this.buyerRepository = buyerRepository;
    }

    @Override
    public PostDto addPost(Integer sellerId, AddPostDto newPost) {

        isPostValid(newPost);

        List<Seller> sellers = sellerRepository.getAll();

        for (Seller seller : sellers) {
            for (Post existingPost : seller.getPosts()) {
                if (existingPost.getProduct().getProductId().equals(newPost.product().productId())) {
                    throw new InvalidArgsException("Ya existe un producto con el product_id '" + existingPost.getProduct().getProductId() + "'.");
                }
            }
        }

        Optional<Seller> foundSeller = sellerRepository.findById(sellerId);
        if (foundSeller.isEmpty()) {
            throw new NotFoundException("No se encontró el vendedor con el id '" + sellerId + "'.");
        }

        Post post = Mapper.convertPostDtoToPost(newPost);
        if (newPost.hasPromo().equals(true)) {
            post.setPrice(newPost.price() - (newPost.price() * newPost.discount()));
        }

        foundSeller.get().getPosts().add(post);
        sellerRepository.update(foundSeller.get());

        return Mapper.convertPostToPostDto(post);
    }

    @Override
    public SellerFollowersListDto getListOrderedAlphabetically(Integer sellerId, String order) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontró el vendedor con el id '" + sellerId + "'.");
        }
        List<BuyerSimpleDto> listBuyerDto;
        if ("name_asc".equals(order))
            listBuyerDto = seller.get().getFollowers().stream()
                    .sorted(Comparator.comparing(Buyer::getUserName))
                    .map(Mapper::convertListToDto)
                    .toList();
        else
            listBuyerDto = seller.get().getFollowers().stream()
                    .sorted(Comparator.comparing(Buyer::getUserName).reversed())
                    .map(Mapper::convertListToDto)
                    .toList();

        return new SellerFollowersListDto(seller.get().getUserId(), seller.get().getUserName(), listBuyerDto);
    }

    @Override
    public SellerDto cantidadSeguidores(Integer sellerId) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontró el vendedor con el id '" + sellerId + "'.");
        }

        int followersCount = sellerRepository.countFollowers(sellerId);
        return Mapper.convertSellerToSellerDTO(seller.get(), followersCount);
    }

    @Override
    public List<PostDto> getRecentPostsFromFollowedSellers(Integer buyerId, String order) {

        Optional<Buyer> foundBuyer = buyerRepository.findById(buyerId);
        if (foundBuyer.isEmpty()) {
            throw new NotFoundException("No se encontró el comprador con el id '" + buyerId + "'.");
        }

        Buyer buyer = foundBuyer.get();
        List<Integer> followedSellerIds = buyer.getFollowed().stream()
                .map(Seller::getUserId).toList();

        List<Seller> allSellers = sellerRepository.getAll();
        List<Seller> followedSellers = allSellers.stream()
                .filter(seller -> followedSellerIds.contains(seller.getUserId()))
                .toList();

        List<PostDto> posts = new ArrayList<>();
        LocalDate dosSemanas = LocalDate.now().minusWeeks(2);
        for (Seller seller : followedSellers) {
            List<Post> sellerPosts = seller.getPosts();
            if (sellerPosts != null) {
                for (Post post : sellerPosts) {
                    if (post.getDate().isAfter(dosSemanas)) {
                        posts.add(Mapper.convertPostToPostDto(post));
                    }
                }
            }
        }
        if (order.equals("date_asc"))
            posts.sort(Comparator.comparing(PostDto::getDate));
        if (order.equals("date_desc"))
            posts.sort(Comparator.comparing(PostDto::getDate).reversed());

        return posts;
    }

    @Override
    public SellerPromosListDto getSellerPromosCount(Integer sellerId) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontró el vendedor con el id '" + sellerId + "'.");
        }

        Integer promosCount = sellerRepository.countSellerPromos(sellerId);
        return Mapper.convertSellerToSellerPromosListDto(seller.get(), promosCount);
    }

    @Override
    public SellerPromosDto getPromoPostsBySeller(Integer sellerId) {
        Optional<Seller> foundSeller = sellerRepository.findById(sellerId);
        if (foundSeller.isEmpty()) {
            throw new NotFoundException("No se encontró el vendedor con el id '" + sellerId + "'.");
        }

        List<PostDto> promoPosts = foundSeller
                .get()
                .getPosts()
                .stream()
                .filter(p -> p.getHasPromo().equals(true))
                .map(p -> Mapper.convertPostToPostDto(p))
                .collect(Collectors.toList());

        return new SellerPromosDto(foundSeller.get().getUserId(), foundSeller.get().getUserName(), promoPosts);
    }

    private void isPostValid(AddPostDto newPost) {
        if (newPost.userId() == null) {
            throw new InvalidArgsException("'user_id' no puede ser null.");
        }

        if (newPost.date() == null) {
            throw new InvalidArgsException("'date' no puede ser null.");
        }

        if (newPost.product() == null) {
            throw new InvalidArgsException("'product' no puede ser null.");
        }

        ProductDto product = newPost.product();
        if (product.productId() == null) {
            throw new InvalidArgsException("'product_id' no puede ser null.");
        }

        if (product.productName() == null || product.productName().isEmpty()) {
            throw new InvalidArgsException("'product_name' no puede ser null ni vacío.");
        }

        if (product.type() == null || product.type().isEmpty()) {
            throw new InvalidArgsException("'type' no puede ser null ni vacío.");
        }

        if (product.brand() == null || product.brand().isEmpty()) {
            throw new InvalidArgsException("'brand' no puede ser null ni vacío.");
        }

        if (product.color() == null || product.color().isEmpty()) {
            throw new InvalidArgsException("'color' no puede ser null ni vacío.");
        }

        if (newPost.category() == null) {
            throw new InvalidArgsException("'category' no puede ser null.");
        }

        if (newPost.price() == null || newPost.price() <= 0) {
            throw new InvalidArgsException("'price' necesita ser un número positivo.");
        }

        if (newPost.hasPromo() == null) {
            throw new InvalidArgsException("'has_promo' no puede ser null.");
        }

        if (newPost.hasPromo() && (newPost.discount() == null || newPost.discount() <= 0)) {
            throw new InvalidArgsException("'discount' es obligatorio cuando se establece 'has_promo' como true.");
        }

        if (!newPost.hasPromo() && (newPost.discount() != null)) {
            throw new InvalidArgsException("'discount' no debe ser especificado cuando 'has_promo' es false.");
        }
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.getAll();
    }
}
