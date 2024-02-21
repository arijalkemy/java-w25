package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dto.BuyerDto;
import grupo_7.sprint_1.dto.GenericResponseDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.entity.User;
import grupo_7.sprint_1.exception.BadRequestException;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.repository.inter.IBuyerRepository;
import grupo_7.sprint_1.repository.inter.ISellerRepository;
import grupo_7.sprint_1.service.inter.IBuyerService;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuyerServiceImp implements IBuyerService {
    IBuyerRepository buyerRepository;
    ISellerRepository sellerRepository;

    public BuyerServiceImp(IBuyerRepository buyerRepository, ISellerRepository sellerRepository) {
        this.buyerRepository = buyerRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public GenericResponseDto followSeller(Integer buyerId, Integer sellerId) {

        Optional<Buyer> foundBuyer = buyerRepository.findById(buyerId);
        if (foundBuyer.isEmpty()) {
            throw new NotFoundException("No se encontró el comprador con el id '" + buyerId + "'.");
        }
        Buyer buyer = foundBuyer.get();

        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (seller.isEmpty()) {
            throw new NotFoundException("No se encontró el vendedor con el id '" + sellerId + "'.");
        }
        List<Seller> followedList = buyer.getFollowed();

        /*if (followedList.stream().filter(s -> s.getUserId().equals(sellerId)).findFirst().isPresent()) {
            throw new BadRequestException("El vendedor ya está en la lista de seguidos");
        }*/
        if (followedList.stream().anyMatch(s -> s.getUserId().equals(sellerId))) {
            throw new BadRequestException("'" + seller.get().getUserName() + "' ya está en la lista de seguidos.");
        }

        followedList.add(seller.get());
        buyer.setFollowed(followedList);
        buyerRepository.update(buyer);
        return new GenericResponseDto("'" + seller.get().getUserName() + "' ha sido agregado a los seguidos.");
    }

    @Override
    public BuyerDto getBuyerfollows(Integer buyerId, String order) {
        Optional<Buyer> foundBuyer = buyerRepository.findById(buyerId);
        if (foundBuyer.isEmpty()) {
            throw new NotFoundException("No se encontró el comprador con el id '" + buyerId + "'.");
        }

        Buyer buyer = foundBuyer.get();
        if (order.equals("name_asc")) {
            buyer.setFollowed(buyer.getFollowed().stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList()));
            return Mapper.convertBuyerToBuyerDto(buyer);
        }
        if (order.equals("name_desc")) {
            buyer.setFollowed(buyer.getFollowed().stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList()));
            return Mapper.convertBuyerToBuyerDto(buyer);
        }
        return null;
    }

    @Override
    public GenericResponseDto unfollowSeller(Integer buyerId, Integer sellerId) {

        Optional<Buyer> foundBuyer = buyerRepository.findById(buyerId);
        if (foundBuyer.isEmpty()) {
            throw new NotFoundException("No se encontró el comprador con el id '" + buyerId + "'.");
        }
        Buyer buyer = foundBuyer.get();

        List<Seller> buyerFollows = buyer.getFollowed();
        if (buyerFollows.isEmpty()) {
            throw new NotFoundException("El comprador con el id '" + buyerId + "' no tiene seguidos.");
        }
        boolean removeFollow = buyerFollows.removeIf(followed -> followed.getUserId().equals(sellerId));

        if (!removeFollow) {
            throw new NotFoundException("No se encontró el seguido con el id '" + sellerId + "'.");
        } else {
            return new GenericResponseDto("El vendedor con el id '" + sellerId + "' ha sido eliminado de los seguidos.");
        }
    }
}
