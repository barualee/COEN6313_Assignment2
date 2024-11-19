package com.assignment2.userservice2.user;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment2.userservice2.entities.User;


@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

}

