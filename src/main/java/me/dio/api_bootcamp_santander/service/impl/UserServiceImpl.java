package me.dio.api_bootcamp_santander.service.impl;

import me.dio.api_bootcamp_santander.domain.model.User;
import me.dio.api_bootcamp_santander.domain.repository.UserRepository;
import me.dio.api_bootcamp_santander.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("Usuario ja existe!");
        }

        if (userRepository.existsByAccount_Number(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Conta ja existe!");
        }

        return userRepository.save(userToCreate);
    }
}
