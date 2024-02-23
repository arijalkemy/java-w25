package com.bootcamp.be_java_hisp_w25_g9.repository;

import com.bootcamp.be_java_hisp_w25_g9.model.Client;
import com.bootcamp.be_java_hisp_w25_g9.model.Seller;
import com.bootcamp.be_java_hisp_w25_g9.model.User;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    List<User> userList = new ArrayList<>();

    public UserRepository(){
        loadUserList();
    }

    @Override
    public String addUser(User user){
        return null;
    }

    @Override
    public List<User> findAll(){
        return this.userList;
    }
    public boolean userExists(long userId){
        Optional<User> userOpt = userList.stream().filter(u -> u.getUserId()==userId).findFirst();
        return userOpt.isPresent();
    }
    public User getUserById(long userId){
        Optional<User> userOpt = userList.stream().filter(u -> u.getUserId()==userId).findFirst();
        if(userExists(userId))
            return userOpt.get();
        return null;
    }
    public void save(User user){
        userList.set(userList.indexOf(getUserById(user.getUserId())),user);
    }

    @Override
    public User getUserById(Integer id) {
        return userList.stream().filter(x -> x.getUserId() == id).findFirst().orElse(null);
    }

    public void loadUserList(){
        userList.add(new Client(1, "Quynn Nunez"));
        userList.add(new Client(2, "Zena Pastor"));
        userList.add(new Client(3, "Sylvia Catalina"));
        userList.add(new Client(4, "Macon Vera"));
        userList.add(new Client(5, "Kyle Arias"));
        userList.add(new Client(6, "Jin Alonso"));
        userList.add(new Client(7, "Ulysses Renato"));
        userList.add(new Client(8, "Kelsey Ramos"));
        userList.add(new Client(9, "Ahmed Gallego"));
        userList.add(new Client(10, "Idona Castillo"));
        userList.add(new Client(11, "Vivien Matias"));
        userList.add(new Client(12, "Daryl Miguel"));
        userList.add(new Client(13, "Clayton Bentlee"));
        userList.add(new Client(14, "Bertha Pastor"));
        userList.add(new Client(15, "Nigel Hernandez"));
        userList.add(new Client(16, "William Gallego"));
        userList.add(new Client(17, "Jared Nuﾑez"));
        userList.add(new Client(18, "Gabriel Gomez"));
        userList.add(new Client(19, "George Bravo"));
        userList.add(new Client(20, "Sybill Martina"));
        userList.add(new Client(21, "Inga Rivera"));
        userList.add(new Client(22, "Omar Perez"));
        userList.add(new Client(23, "Kay Medina"));
        userList.add(new Client(24, "Zia Martina"));
        userList.add(new Client(25, "Stacy Sanchez"));
        userList.add(new Seller(26, "Chase Sanchez"));
        userList.add(new Seller(27, "Gregory Bravo"));
        userList.add(new Seller(28, "Zelda Atlas"));
        userList.add(new Seller(29, "Josiah Sanchez"));
        userList.add(new Seller(30, "Patrick Blanco"));
        userList.add(new Seller(31, "Otto Camila"));
        userList.add(new Seller(32, "Madeline Reyes"));
        userList.add(new Seller(33, "Carla Gutierrez"));
        userList.add(new Seller(34, "Noble Lorenzo"));
        userList.add(new Seller(35, "Deacon Marquez"));
        userList.add(new Seller(36, "Molly Martina"));
        userList.add(new Seller(37, "Chase Tapia"));
        userList.add(new Seller(38, "Leigh Gabriela"));
        userList.add(new Seller(39, "Basil Maximiliano"));
        userList.add(new Seller(40, "Jamal Rocio"));
        userList.add(new Seller(41, "Hu Izquierdo"));
        userList.add(new Seller(42, "Rowan Castillo"));
        userList.add(new Seller(43, "Carly Pascal"));
        userList.add(new Seller(44, "Hedley Morales"));
        userList.add(new Seller(45, "Raven Leon"));
        userList.add(new Seller(46, "Teegan Nuﾑez"));
        userList.add(new Seller(47, "Ifeoma Rocio"));
        userList.add(new Seller(48, "Lillith Reyes"));
        userList.add(new Seller(49, "Odessa Pia"));
        userList.add(new Seller(50, "Jackson Crespo"));
    }


}
