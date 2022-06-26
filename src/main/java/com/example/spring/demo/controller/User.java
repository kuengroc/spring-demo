package com.example.spring.demo.controller;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Accessors(chain = true)
@Document(indexName = "user", createIndex = true)
public class User {
    @Id
    private String sid;
    private String userId;
    private Integer age;
    private String add;
}
