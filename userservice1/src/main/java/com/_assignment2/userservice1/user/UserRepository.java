package com._assignment2.userservice1.user;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com._assignment2.userservice1.entities.User;


@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

}

