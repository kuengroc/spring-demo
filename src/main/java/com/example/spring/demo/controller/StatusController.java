package com.example.spring.demo.controller;

import com.example.spring.demo.exception.StatusException;
import com.example.spring.demo.repostory.UserRepostory;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("status")
@AllArgsConstructor
public class StatusController {
    private final UserRepostory userRepostory;
    private ElasticsearchRestTemplate template;

    @GetMapping
    public Optional<User> get(String sid) {
        return userRepostory.findById(sid);
    }

    @GetMapping("exist")
    public boolean search(String sid) {
        return userRepostory.existsById(sid);
    }

    @PostMapping
    public User post() {
        return userRepostory.save(new User().setUserId("123").setAdd("sde").setAge(10));
    }

    @PutMapping
    public User put(String sid) {
//        saveOrUpdate
        return userRepostory.save(new User().setSid(sid).setUserId("456").setAdd("aaa").setAge(10));
    }

    @GetMapping("/404")
    public String notFound() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found xxx");
    }

    @GetMapping("/400")
    public String badRequest() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "bad request");
    }

    @GetMapping("/400x")
    public ResponseEntity<String> badRequestx() {
        return ResponseEntity.ok().header("code", "0").header("msg", "xxxxx").body("sdfa");
    }

    @GetMapping("/400xx")
    public User badRequestxx(@Valid @NotNull Integer a) {
        if (a > 10) {
            throw new StatusException(HttpStatus.BAD_REQUEST, "不能大于10", null);
        }
        return new User().setUserId("s").setAdd("sde").setAge(10);
    }
}
