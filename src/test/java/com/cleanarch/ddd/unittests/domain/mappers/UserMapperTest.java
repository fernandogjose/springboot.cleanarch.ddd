package com.cleanarch.ddd.unittests.domain.mappers;

import com.cleanarch.ddd.domain.mappers.Mapper;
import com.cleanarch.ddd.domain.models.User;
import com.cleanarch.ddd.domain.valueObjects.UserVo;
import com.cleanarch.ddd.unittests.domain.mappers.mocks.UserMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {

    UserMock userMock;

    @BeforeEach
    public void setUp() {
        userMock = new UserMock();
    }

    @Test
    public void whenParseModelToVo_shouldMapper_withSuccess() {
        var userVo = Mapper.parseObject(userMock.mockModel(), UserVo.class);

        assertEquals(0L, userVo.getId());
        assertEquals("username0", userVo.getUsername());
        assertEquals("password0", userVo.getPassword());
    }

    @Test
    public void whenParseVoToModel_shouldMapper_withSuccess() {
        var user = Mapper.parseObject(userMock.mockVo(), User.class);

        assertEquals(0L, user.getId());
        assertEquals("username0", user.getUsername());
        assertEquals("password0", user.getPassword());
    }
}
