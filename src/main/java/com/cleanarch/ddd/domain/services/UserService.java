package com.cleanarch.ddd.domain.services;

import com.cleanarch.ddd.domain.exceptions.ResourceNotFoundException;
import com.cleanarch.ddd.domain.mappers.Mapper;
import com.cleanarch.ddd.domain.models.User;
import com.cleanarch.ddd.domain.valueObjects.UserVo;
import com.cleanarch.ddd.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    private final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    UserRepository userRepository;

    public List<UserVo> findAll() {
        logger.info("Finding all users");
        var usersInDb = userRepository.findAll();
        return Mapper.parseObject(usersInDb, UserVo.class);
    }

    public UserVo findById(Long id) {
        logger.info("Finding by id");
        var userInDb = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        return Mapper.parseObject(userInDb, UserVo.class);
    }

    public UserVo create(UserVo userVoRequest) {
        logger.info("Add user");
        var userToCreate = Mapper.parseObject(userVoRequest, User.class);
        var userCreated = userRepository.save(userToCreate);
        return Mapper.parseObject(userCreated, UserVo.class);
    }

    public UserVo update(UserVo userVoRequest) {
        logger.info("update user");
        userRepository.findById(userVoRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        userRepository.save(Mapper.parseObject(userVoRequest, User.class));
        return userVoRequest;
    }

    public void delete(Long id) {
        logger.info("delete user");
        var userToDelete = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        userRepository.delete(userToDelete);
    }
}
