package com.temirbayev.kameleoon.service;

import com.temirbayev.kameleoon.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> userList();
    Users createUser(Users user);
    Users getUserById(Long userId);
    void deleteUser(Long userId);

    List<Users> getGyName(String name);


}
