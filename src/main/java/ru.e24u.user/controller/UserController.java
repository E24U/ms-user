package ru.e24u.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.e24u.user.entity.User;
import ru.e24u.user.service.UserService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{uuid}")
    public User findById(@PathVariable UUID uuid) {
        return userService.findById(uuid);
    }

    @PutMapping("/user/{uuid}")
    public void update(@PathVariable UUID uuid, @RequestBody User user) {
        userService.updateUser(uuid, user);
    }

    @DeleteMapping("/user/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        userService.deleteUser(uuid);
    }
}
