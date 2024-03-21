package com.cleanarch.ddd.application.controllers;

import com.cleanarch.ddd.domain.valueObjects.UserVo;
import com.cleanarch.ddd.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserVo> findAll() {
        return userService.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public UserVo findById(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }
}
