package com.temirbayev.kameleoon.service.impl;

import com.temirbayev.kameleoon.model.Users;
import com.temirbayev.kameleoon.repository.UserRepository;
import com.temirbayev.kameleoon.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public List<Users> userList(){
        return userRepository.findAll();

    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<Users> getGyName(String name) {
        return userRepository.findByName(name);
    }

}
