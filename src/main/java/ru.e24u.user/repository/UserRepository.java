package ru.e24u.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.e24u.user.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User username(String username);
}
