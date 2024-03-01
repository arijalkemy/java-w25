package com.bootcamp.be_java_hisp_w25_g9.repository;

import com.bootcamp.be_java_hisp_w25_g9.model.Client;
import com.bootcamp.be_java_hisp_w25_g9.model.Seller;
import com.bootcamp.be_java_hisp_w25_g9.model.User;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    List<User> userList = new ArrayList<>();

    public UserRepository(){
        loadUserList();
    }

    @Override
    public List<User> findAll(){
        return this.userList;
    }
    public boolean userExists(Integer userId){
        Optional<User> userOpt = userList.stream().filter(u -> Objects.equals(u.getUserId(), userId)).findFirst();
        return userOpt.isPresent();
    }

    public void save(User user){
        userList.set(userList.indexOf(getUserById(user.getUserId())),user);
    }

    @Override
    public User getUserById(Integer id) {
        return userList.stream().filter(x -> x.getUserId().equals(id)).findFirst().orElse(null);
    }

    public void loadUserList(){
        Client client1 = new Client(1, "Quynn Nunez");
        Client client2 = new Client(2, "Zena Pastor");
        Client client3 = new Client(3, "Sylvia Catalina");
        Client client4 = new Client(4, "Macon Vera");
        Client client5 = new Client(5, "Kyle Arias");
        Client client6 = new Client(6, "Jin Alonso");
        Client client7 = new Client(7, "Ulysses Renato");
        Client client8 = new Client(8, "Kelsey Ramos");
        Client client9 = new Client(9, "Ahmed Gallego");
        Client client10 = new Client(10, "Idona Castillo");
        Client client11 = new Client(11, "Vivien Matias");
        Client client12 = new Client(12, "Daryl Miguel");
        Client client13 = new Client(13, "Clayton Bentlee");
        Client client14 = new Client(14, "Bertha Pastor");
        Client client15 = new Client(15, "Nigel Hernandez");
        Client client16 = new Client(16, "William Gallego");
        Client client17 = new Client(17, "Jared Nuﾑez");
        Client client18 = new Client(18, "Gabriel Gomez");
        Client client19 = new Client(19, "George Bravo");
        Client client20 = new Client(20, "Sybill Martina");
        Client client21 = new Client(21, "Inga Rivera");
        Client client22 = new Client(22, "Omar Perez");
        Client client23 = new Client(23, "Kay Medina");
        Client client24 = new Client(24, "Zia Martina");
        Client client25 = new Client(25, "Stacy Sanchez");
        Seller seller26 = new Seller(26, "Chase Sanchez");
        Seller seller27 = new Seller(27, "Gregory Bravo");
        Seller seller28 = new Seller(28, "Zelda Atlas");
        Seller seller29 = new Seller(29, "Josiah Sanchez");
        Seller seller30 = new Seller(30, "Patrick Blanco");
        Seller seller31 = new Seller(31, "Otto Camila");
        Seller seller32 = new Seller(32, "Madeline Reyes");
        Seller seller33 = new Seller(33, "Carla Gutierrez");
        Seller seller34 = new Seller(34, "Noble Lorenzo");
        Seller seller35 = new Seller(35, "Deacon Marquez");
        Seller seller36 = new Seller(36, "Molly Martina");
        Seller seller37 = new Seller(37, "Chase Tapia");
        Seller seller38 = new Seller(38, "Leigh Gabriela");
        Seller seller39 = new Seller(39, "Basil Maximiliano");
        Seller seller40 = new Seller(40, "Jamal Rocio");
        Seller seller41 = new Seller(41, "Hu Izquierdo");
        Seller seller42 = new Seller(42, "Rowan Castillo");
        Seller seller43 = new Seller(43, "Carly Pascal");
        Seller seller44 = new Seller(44, "Hedley Morales");
        Seller seller45 = new Seller(45, "Raven Leon");
        Seller seller46 = new Seller(46, "Teegan Nuﾑez");
        Seller seller47 = new Seller(47, "Ifeoma Rocio");
        Seller seller48 = new Seller(48, "Lillith Reyes");
        Seller seller49 = new Seller(49, "Odessa Pia");
        Seller seller50 = new Seller(50, "Jackson Crespo");
        userList.add(client1);
        userList.add(client2);
        userList.add(client3);
        userList.add(client4);
        userList.add(client5);
        userList.add(client6);
        userList.add(client7);
        userList.add(client8);
        userList.add(client9);
        userList.add(client10);
        userList.add(client11);
        userList.add(client12);
        userList.add(client13);
        userList.add(client14);
        userList.add(client15);
        userList.add(client16);
        userList.add(client17);
        userList.add(client18);
        userList.add(client19);
        userList.add(client20);
        userList.add(client21);
        userList.add(client22);
        userList.add(client23);
        userList.add(client24);
        userList.add(client25);
        userList.add(seller26);
        userList.add(seller27);
        userList.add(seller28);
        userList.add(seller29);
        userList.add(seller30);
        userList.add(seller31);
        userList.add(seller32);
        userList.add(seller33);
        userList.add(seller34);
        userList.add(seller35);
        userList.add(seller36);
        userList.add(seller37);
        userList.add(seller38);
        userList.add(seller39);
        userList.add(seller40);
        userList.add(seller41);
        userList.add(seller42);
        userList.add(seller43);
        userList.add(seller44);
        userList.add(seller45);
        userList.add(seller46);
        userList.add(seller47);
        userList.add(seller48);
        userList.add(seller49);
        userList.add(seller50);

        client1.getFollowed().addAll(List.of(seller26, seller27, seller28, seller29, seller30));
        client3.getFollowed().addAll(List.of(seller26, seller27, seller28));
    }


}
