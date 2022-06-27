package com.lin.mongo.demo.user.dao;

import com.lin.mongo.demo.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface UserDao extends MongoRepository<User ,String> {

    List<User> findByName(@Param("name") String name);

}
