package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

@Repository

public interface userRepo extends JpaRepository<User, String> {

    //extra methods db relatedoperations
    //custom query methods
    //custom finder methods

    Optional<User> findByEmail(String email);//if few methods are not predefined available you can make it them
   // Optional<User> findByEmailAndPassword(String email, String password);
    


}