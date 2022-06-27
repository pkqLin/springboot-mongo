package com.lin.mongo.demo.user.entity;

import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
public class User {
    @Id
    private String id;

    private String name;

    private Integer age;

    public User() {

    }
}
