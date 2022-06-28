package com.lin.mongo.demo.user.controller;

import com.lin.mongo.demo.system.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisCsController {

    //基于基类编写的工具类
    @Autowired
    private RedisUtils redisUtils;


    //查询key
    @GetMapping("get/{key}")
    public Object get(@PathVariable("key")String key){
        return redisUtils.get(key);
    }

    //插入数据key,value
    @PostMapping("save/{key}/{value}")
    public String save(@PathVariable("key")String key,@PathVariable("value")String value){
        redisUtils.set(key,value);
        return "插入成功";
    }

    //更新key,value
    @PostMapping("/update/{key}/{value}")
    public String update(@PathVariable("key")String key,@PathVariable("value")String value){
        redisUtils.getAndSet(key,value);
        return "更新成功";
    }

    //根据key删除数据
    @DeleteMapping("dele/{key}")
    public String dele(@PathVariable("key")String key) {
        redisUtils.delete(key);
        return "删除成功";
    }


}
 