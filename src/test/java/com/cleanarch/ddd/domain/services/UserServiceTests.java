package com.cleanarch.ddd.domain.services;

import com.cleanarch.ddd.domain.exceptions.RequiredException;
import com.cleanarch.ddd.infra.repositories.UserRepository;
import com.cleanarch.ddd.unittests.domain.mappers.mocks.UserMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    UserMock userMock;

    @InjectMocks
    private UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUpMocks() {
        userMock = new UserMock();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_shouldReturnListOfUser_whenSuccess() {

    }

    @Test
    void findById_shouldReturnUser_whenHasInDb() {
        var user = userMock.mockModel();
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        var userResult = userService.findById(user.getId());

        assertNotNull(userResult);
        assertEquals(userResult.getId(), user.getId());
        assertEquals(userResult.getUsername(), user.getUsername());
        assertEquals(userResult.getPassword(), user.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void create_shouldReturnRequiredException_whenUsernameIsEmptyOrNull(String username) {
        var userVoRequest = userMock.mockVo();
        userVoRequest.setUsername(username);

        Exception exception = assertThrows(RequiredException.class, () -> userService.create(userVoRequest));

        var expectedMessage = "Nome do usuário é obrigatório";
        var actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
