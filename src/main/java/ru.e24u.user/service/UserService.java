package ru.e24u.user.service;

import org.springframework.stereotype.Service;
import ru.e24u.user.entity.User;
import ru.e24u.user.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (userRepository.username(user.getUsername()) != null) {
            throw new IllegalArgumentException("Пользователь с таким именем уже существует");
        }
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new IllegalArgumentException("Проверьте правильность заполнения имени");
        }
    }

    public User findById(UUID uuid) {
        try {
            return userRepository.findById(uuid).orElse(null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Пользователь не найден");
        }
    }

    public void updateUser(UUID uuid, User user) {
        try {
            User rsl = userRepository.findById(uuid).get();
            rsl.setUsername(user.getUsername());
            rsl.setPassword(user.getPassword());
            userRepository.save(rsl);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void deleteUser(UUID uuid) {
        try {
            User rsl = new User();
            rsl.setUuid(uuid);
            userRepository.delete(rsl);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
