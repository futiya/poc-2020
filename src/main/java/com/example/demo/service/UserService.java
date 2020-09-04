package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2020-09-03 17:00
 */
public interface UserService {
    List<User> listAll();
    User findUser(int id);
    void addUser(User user);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
