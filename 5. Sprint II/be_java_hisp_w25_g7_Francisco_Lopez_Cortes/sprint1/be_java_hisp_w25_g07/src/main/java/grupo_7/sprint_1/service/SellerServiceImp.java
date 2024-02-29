package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.*;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.BadRequestException;
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


    @Override
    public SellerDTO cantidadSeguidores(int id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontro el vendedor con el id: " + id);
        }

        int followersCount = sellerRepository.cantidadDeSeguidoresRepo(id);
        return Mapper.convertSellerToSellerDTO(seller.get(), followersCount);
    }

    @Override
    public List<PostDto> getRecentPostsFromFollowedSellers(Integer buyerId, String order) {

        Buyer buyer = buyerRepository.findBuyerById(buyerId);
        if (buyer == null) {
            throw new NotFoundException("El comprador con el ID " + buyerId + " no existe");
        }
        if (!order.equals("date_asc") && !order.equals("date_desc")) {
            throw new BadRequestException("El orden ingresado no es válido.");
        }
        List<Integer> followedSellerIds = buyer.getFollowed().stream()
                .map(Seller::getUserId).toList();

        List<Seller> allSellers = sellerRepository.getAllSellers();
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

}
