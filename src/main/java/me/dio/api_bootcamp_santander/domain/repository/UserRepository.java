package me.dio.api_bootcamp_santander.domain.repository;

import me.dio.api_bootcamp_santander.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
