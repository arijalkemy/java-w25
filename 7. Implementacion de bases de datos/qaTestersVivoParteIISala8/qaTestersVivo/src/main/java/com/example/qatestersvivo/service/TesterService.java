package com.example.qatestersvivo.service;

import com.example.qatestersvivo.entity.Tester;
import com.example.qatestersvivo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TesterService {
    private IUserRepository userRepository;

    public TesterService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<Tester> getAllTesters(){
        return userRepository.findAll();
    }

    public Tester createTester(Tester tester){
        return userRepository.save(tester);
    }


}
