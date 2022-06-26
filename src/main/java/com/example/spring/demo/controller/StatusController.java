package com.example.spring.demo.controller;

import com.example.spring.demo.exception.StatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("status")
public class StatusController {
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
