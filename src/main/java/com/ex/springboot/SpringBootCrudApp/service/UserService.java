package com.ex.springboot.SpringBootCrudApp.service;

import com.ex.springboot.SpringBootCrudApp.bean.Users;

import java.util.List;

public interface UserService {
    Integer saveUsers(Users users);

    List<Users> getAllUsers();

    Users getOneUser(Integer id);

    void deleteUser(Integer id);

    void updateUser(Users users);

     List<Users> searchUser(String keyword);
}


