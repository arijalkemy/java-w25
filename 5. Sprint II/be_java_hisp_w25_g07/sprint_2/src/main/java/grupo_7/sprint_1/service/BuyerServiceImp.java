package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.GenericResponseDTO;
import grupo_7.sprint_1.dtos.MessageDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.entity.User;
import grupo_7.sprint_1.exception.BadRequestException;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
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
    public GenericResponseDTO followSeller(Integer buyerId, Integer sellerId) {
        Buyer buyer = buyerRepository.findBuyerById(buyerId);
        if (buyer == null) {
            throw new BadRequestException("El comprador no existe");
        }
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (seller.isEmpty()) {
            throw new BadRequestException("El vendedor no existe");
        }
        List<Seller> followedList = buyer.getFollowed();
        if (followedList.stream().filter(s -> s.getUserId().equals(sellerId)).findFirst().isPresent()) {
            throw new BadRequestException("El vendedor ya está en la lista de seguidos");
        }
        followedList.add(seller.get());
        buyer.setFollowed(followedList);
        buyerRepository.updateBuyer(buyer);
        return new GenericResponseDTO("El vendedor se ha seguido correctamente");
    }

    @Override
    public BuyerDto getBuyerfollow(Integer id, String order) {
        Buyer buyer = buyerRepository.findBuyerById(id);
        if (buyer == null) {
            throw new NotFoundException("el id ingresado no corresponde a ningun comprador");
        }
        if (order != "name_asc" && order != "name_desc"){
            throw new BadRequestException("No se ha ingresado una opción de ordenamiento válida");
        }
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
    public MessageDto unfollowSeller(int idUser, int userIdToUnfollow) {
        Buyer buyerFolloweds = buyerRepository.findBuyerById(idUser);

        if(buyerFolloweds == null) {
            throw new NotFoundException("No se encuentra el id del comprador");
        }

        boolean removeFollow = buyerFolloweds.getFollowed().removeIf(followed -> followed.getUserId() == userIdToUnfollow);

        if (!removeFollow) {
            throw new NotFoundException("No se encuentra el followed");
        } else {
            return new MessageDto("Se eliminó de seguidores correctamente");
        }
    }
}
