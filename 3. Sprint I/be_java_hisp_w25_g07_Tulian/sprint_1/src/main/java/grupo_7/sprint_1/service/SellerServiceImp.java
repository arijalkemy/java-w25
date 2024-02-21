package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.*;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.InvalidArgsException;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

        List<Seller> sellers = sellerRepository.getAllSellers();

        for (Seller seller : sellers) {
            for (Post existingPost : seller.getPosts()) {
                if (existingPost.getProduct().getProductId().equals(newPost.product().productId())) {
                    throw new InvalidArgsException("Ya existe un producto con el mismo 'product_id'.");
                }
            }
        }

        Optional<Seller> foundSeller = sellerRepository.findById(sellerId);
        if (foundSeller.isEmpty()) {
            throw new NotFoundException("El vendedor indicado no existe.");
        }

        Post post = Mapper.convertPostDtoToPost(newPost);
        foundSeller.get().getPosts().add(post);
        sellerRepository.updateSeller(foundSeller.get());

        return Mapper.convertPostToPostDto(post);
    }

    @Override
    public SellerFollowersListDto getListOrderedAlphabetically(Integer userId, String order) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontro el vendedor con el id: " + userId);
        }
        List<BuyerDtoRequisito3> listBuyerDto;
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

    private void isPostValid(AddPostDto newPost) {
        if (newPost.userId() == null) {
            throw new InvalidArgsException("'user_id' no puede ser null.");
        }

        if (newPost.date() == null) {
            throw new InvalidArgsException("'date' no puede ser null.");
        }

        if (newPost.category() == null) {
            throw new InvalidArgsException("'category' no puede ser null.");
        }

        if (newPost.price() == null || newPost.price() <= 0) {
            throw new InvalidArgsException("'price' necesita ser un número positivo.");
        }
        if (newPost.has_promo() && newPost.discount() <= 0) {
            throw new InvalidArgsException("'discount' necesita ser un número positivo.");
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
    }

    @Override
    public SellerDTO cantidadSeguidores(int id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontro el vendedor con el id: " + id);
        }

        int followersCount = sellerRepository.cantidadDeSeguidores(id);
        return Mapper.convertSellerToSellerDTO(seller.get(), followersCount);
    }

    @Override
    public List<PostDto> getRecentPostsFromFollowedSellers(Integer buyerId, String order) {

        Buyer buyer = buyerRepository.findBuyerById(buyerId);
        if (buyer == null) {
            throw new NotFoundException("El comprador con el ID " + buyerId + " no existe");
        }
        List<Integer> followedSellerIds = buyer.getFollowed().stream()
                .map(Seller::getUserId).toList();

        List<Seller> allSellers = sellerRepository.getAllSellers();
        List<Seller> followedSellers = allSellers.stream()
                .filter(seller -> followedSellerIds.contains(seller.getUserId()))
                .toList();

        List<PostDto> posts = new ArrayList<>();
        LocalDate dosSemanas = LocalDate.now().minusWeeks(4);
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
    public List<Seller> getAllSellers() {
        return sellerRepository.getAllSellers();
    }
    public SellerPromDto cantidadProductosPromocion(int id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontro el vendedor con el id: " + id);
        }

        int promoPostsCount = sellerRepository.cantidadDeProductosPromocion(id);
        return Mapper.convertSellerToSellerDTOprom(seller.get(), promoPostsCount);
    }

    @Override
    public ListPostSellerDto listaPostsPromocion(int userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontro el vendedor con el id: " + userId);
        }
        seller.get().setPosts(seller.get().getPosts().stream().filter(Post::isHas_promo).toList());
        return Mapper.convertSellerToListPostsProm(seller.get());

    }
    }



