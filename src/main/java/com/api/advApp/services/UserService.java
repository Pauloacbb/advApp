package com.api.advApp.services;

import com.api.advApp.models.UserModel;
import com.api.advApp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public void delete(UserModel userModel){
        userRepository.delete(userModel);
    }

}
