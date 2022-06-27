package com.lin.mongo.demo.user.controller;

import com.lin.mongo.demo.user.dao.UserDao;
import com.lin.mongo.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class UserController  {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserDao userDao;

    @GetMapping("query")
    public String query(){
       List<User> user =userDao.findByName("吕");
        System.out.println(user);
        return "200";
    }

    @GetMapping("insert")
    public String inset(){
       User user =new User();
       user.setAge(18);
       user.setId("1214");
       user.setName("张三");
        System.out.println(user);
        userDao.insert(user);
        return "200";
    }

}
