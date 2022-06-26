package com.example.spring.demo.controller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private String userId;
    private Integer age;
    private String add;
}
