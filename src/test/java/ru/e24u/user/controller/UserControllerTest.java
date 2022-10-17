package ru.e24u.user.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.e24u.user.entity.User;
import ru.e24u.user.service.UserService;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserControllerTest {

    @MockBean
    UserService service;

    @Autowired
    UserController controller;

    @Test
    public void whenCreateUserThenTrue() {
        User user = new User();
        service.createUser(user);
        Mockito.verify(service, Mockito.times(1)).createUser(user);
    }

    @Test
    public void whenCreateUserThenException() {
        User user = new User();
        Mockito.when(service.createUser(user)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> controller.create(user));
    }

    @Test
    public void whenGetByIdUserThenTrue() {
        User user = new User();
        service.findById(user.getUuid());
        Mockito.verify(service, Mockito.times(1)).findById(user.getUuid());
    }

    @Test
    public void whenGetByIdUserThenFalse() {
        User user = new User();
        Mockito.when(service.findById(user.getUuid())).thenReturn(user);

        assertThrows(IllegalArgumentException.class, () -> controller.findById(user.getUuid()));
    }
}