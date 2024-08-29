package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.scm.repositories.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
   private userRepo userRepo;

   private Logger logger = LoggerFactory.getLogger(getClass());//import org.slf4j


    @Override
    public User saveUser(User user) {
        //user id : have to generate-dynamic generate
        
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);
        //password encode yaha karenge
        //user.setPassword(userId);
        
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        
        User user2=userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        //update karenge user2 from user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        //save the user in db
      User save=userRepo.save(user2);
      return Optional.ofNullable(save);

    }

    @Override
    public boolean isUserExist(String userId) {
        
        User user4 = userRepo.findById(userId).orElse(null);
        return user4!=null?true : false;
    }

    @Override
    public boolean isUserExistByUserName(String email) {
        User user5 = userRepo.findByEmail(email).orElse(null);
        return user5!=null?true:false;
    }

    @Override
    public List<User> getAllUsers() {
        
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(String id) {
        
        User user3 = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not Found"));
         userRepo.delete(user3);
    }
    
}
