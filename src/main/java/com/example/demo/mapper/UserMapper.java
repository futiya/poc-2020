package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2020-09-03 17:12
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS")
    List<User> listAll();
    @Select("SELECT * FROM USERS WHERE ID=#{id}")
    User findUser(int id);

    @Insert("INSERT INTO USERS(email,name,\"managerId\",\"createdAt\",\"updatedAt\") VALUES(#{email},#{name},#{managerId},#{createdAt},#{updatedAt})")
    void addUser(User user);
    @Update("UPDATE USERS SET email=#{user.email},name=#{user.name},\"managerId\"=#{user.managerId},\"updatedAt\"=#{user.updatedAt} where id=#{id}")
    void updateUser(int id, User user);
    @Delete("DELETE FROM USERS WHERE id=#{id}")
    int deleteUser(int id);
}
