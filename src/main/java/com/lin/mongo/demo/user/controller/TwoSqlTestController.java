package com.lin.mongo.demo.user.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class TwoSqlTestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @DS("master")
    //没有则是默认数据源
    @GetMapping("sql/query1")
    public void test1(){
        List<Map<String, Object>> users = jdbcTemplate.queryForList(" SELECT * FROM t_user ");
        System.out.println("数据库1数据：" + users);
    }

    @DS("other")
    @GetMapping("sql/query2")
    public void test2(){
        List<Map<String, Object>> roles = jdbcTemplate.queryForList(" SELECT * FROM sys_user ");
        System.out.println("数据库2数据：" + roles);
    }

}
