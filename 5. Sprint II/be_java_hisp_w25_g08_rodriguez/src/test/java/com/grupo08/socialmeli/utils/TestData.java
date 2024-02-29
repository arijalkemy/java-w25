package com.grupo08.socialmeli.utils;

import com.grupo08.socialmeli.dto.response.FollowDto;
import com.grupo08.socialmeli.dto.response.FollowedDTO;
import com.grupo08.socialmeli.entity.Buyer;
import com.grupo08.socialmeli.entity.Seller;
import com.grupo08.socialmeli.entity.User;
import com.grupo08.socialmeli.exception.BadRequestException;
import io.swagger.v3.oas.models.security.SecurityScheme;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestData {

    public static Seller getBasicSeller(Integer id,
                                        String name){
        Seller seller = new Seller();
        seller.setId(id);
        seller.setName(name);

        return seller;
    }

    public static List<Seller> getBasicSellers(String order){

        List<Seller> sellers = new ArrayList<>();
        sellers.add(getBasicSeller(123,"Leonel Ronaldo"));
        sellers.add(getBasicSeller(456,"Cristiano Messi"));
        sellers.add(getBasicSeller(123,"Kylian Haaland"));
        sellers.add(getBasicSeller(123,"Erling Mbappe"));

        if(order!=null){
            if(order.equalsIgnoreCase("name_asc")){
                return sellers.stream()
                        .sorted(Comparator.comparing(User::getName)).toList();
            }else if(order.equalsIgnoreCase("name_desc")){
                return sellers.stream()
                        .sorted(Comparator.comparing(User::getName).reversed()).toList();
            }
        }
        return sellers;
    }

    public static boolean isFollowedSellersSorted(List<FollowDto> sellers, String order){
        for (int i = 0; i < sellers.size()-1; i++) {
            if(sellers.get(i).getUserName()
                    .compareTo(sellers.get(i+1).getUserName())>0
                    && order.equals("name_asc")){
                return false;
            }
            if(sellers.get(i).getUserName()
                    .compareTo(sellers.get(i+1).getUserName())<0
                    && order.equals("name_desc")){
                return false;
            }
        }
        return true;
    }

    public static Buyer getBuyerWithFollowedSellers(Integer id,
                                                    String name){
        Buyer buyer = new Buyer();
        buyer.setId(id);
        buyer.setName(name);
        buyer.setFollowing(getBasicSellers(null));

        return buyer;
    }

    public static FollowedDTO getFollowedDTOResponse(int userId){
        Buyer buyer = getBuyerWithFollowedSellers(userId,"TestMan");
        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUserId(buyer.getId());
        followedDTO.setUserName(buyer.getName());

        List<FollowDto> followedSellersDTO = new ArrayList<>();

        for(Seller seller: buyer.getFollowing()){
            followedSellersDTO.add(new FollowDto(seller.getId(),seller.getName()));
        }

        followedDTO.setFollowed(followedSellersDTO);

        return followedDTO;
    }
}
