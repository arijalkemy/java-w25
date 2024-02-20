package com.bootcamp.be_java_hisp_w25_g02.repository;

import com.bootcamp.be_java_hisp_w25_g02.entity.User;
import com.bootcamp.be_java_hisp_w25_g02.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g02.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository{
    List<User> userList;
    public UserRepositoryImpl(){
        loadUsers();
    }
    private void loadUsers(){
        userList = new ArrayList<>(List.of(
           new User(1, "Javier", false, new ArrayList<>(List.of(
                   7,9

           )), new ArrayList<>()),
                new User(2, "NA", false, new ArrayList<>(), new ArrayList<>()),
                new User(3, "Martin", false, new ArrayList<>(), new ArrayList<>()),
                new User(7, "Maria", true, new ArrayList<>(),

                        new ArrayList<>(List.of(1)
                        )),
                new User(8, "Marcos", false, new ArrayList<>(), new ArrayList<>(

                )),
                new User(9, "Malena", true, new ArrayList<>(), new ArrayList<>(
                        List.of(1, 3, 7)
                )),
                new User(10, "JoseMaria", true, new ArrayList<>(), new ArrayList<>(
                        List.of(1)
                )),
                new User(11, "Pedro Gomez", true, new ArrayList<>(), new ArrayList<>())

        ));
    }


    @Override
    public Optional<User> findById(Integer id) {
        return this.userList.stream().filter(user -> user.getUser_id().equals(id)).findFirst();
    }

    @Override
    public List<User> findAll() {
        return this.userList;
    }


}
