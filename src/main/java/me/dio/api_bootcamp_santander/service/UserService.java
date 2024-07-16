package me.dio.api_bootcamp_santander.service;

import me.dio.api_bootcamp_santander.domain.model.User;

public interface UserService {

    User findById(Long id);
    User create(User userToCreate);
}
