package com.cleanarch.ddd.unittests.domain.mappers.mocks;

import com.cleanarch.ddd.domain.models.User;
import com.cleanarch.ddd.domain.valueObjects.UserVo;

import java.util.ArrayList;
import java.util.List;

public class UserMock {

    public User mockModel() {
        return mockModel(0L);
    }

    public UserVo mockVo() {
        return mockVo(0L);
    }

    public List<User> mockModels() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            users.add(mockModel((long) i));
        }
        return users;
    }

    public List<UserVo> mockVos() {
        List<UserVo> usersVo = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            usersVo.add(mockVo((long) i));
        }
        return usersVo;
    }

    private User mockModel(Long id) {
        return new User(id, "username" + id, "password" + id);
    }

    private UserVo mockVo(Long id) {
        var userVo = new UserVo();
        userVo.setId(id);
        userVo.setUsername("username" + id);
        userVo.setPassword("password" + id);
        return userVo;
    }
}
