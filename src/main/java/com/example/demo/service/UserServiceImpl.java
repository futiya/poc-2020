package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2020-09-03 17:09
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public User findUser(int id) {
        return userMapper.findUser(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(int id, User user) {
        userMapper.updateUser(id,user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
