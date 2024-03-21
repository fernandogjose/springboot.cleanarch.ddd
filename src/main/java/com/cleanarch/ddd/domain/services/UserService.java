package com.cleanarch.ddd.domain.services;

import com.cleanarch.ddd.domain.exceptions.ResourceNotFoundException;
import com.cleanarch.ddd.domain.mappers.Mapper;
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
        var userInDb = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));

        return Mapper.parseObject(userInDb, UserVo.class);
    }
}
