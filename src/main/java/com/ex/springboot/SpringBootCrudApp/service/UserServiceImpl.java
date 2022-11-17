package com.ex.springboot.SpringBootCrudApp.service;

import com.ex.springboot.SpringBootCrudApp.bean.Users;
import com.ex.springboot.SpringBootCrudApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Integer saveUsers(Users users) {
        return  userRepository.save(users).getId();
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll(Sort.by("Id"));
    }

    @Override
    public Users getOneUser(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public void updateUser(Users users) {
        userRepository.save(users);

    }

    @Override
    public List<Users> searchUser(String keyword) {

            return userRepository.search(keyword);

    }
}
