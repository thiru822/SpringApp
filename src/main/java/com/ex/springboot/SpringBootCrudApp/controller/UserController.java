package com.ex.springboot.SpringBootCrudApp.controller;


import com.ex.springboot.SpringBootCrudApp.bean.Users;

import com.ex.springboot.SpringBootCrudApp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/login")
    public String loginForm(){
                return "login";
    }
    @GetMapping("/register")
    public String registerForm(){
        return "UserRegistration";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute Users users,Model model){
        Integer id= userService.saveUsers(users);
        String message = "User '"+id+"' created";
        model.addAttribute("message", message);
        return "login";
    }
    @GetMapping("/All")
    public String getAll(Model model){
       List<Users> list= userService.getAllUsers();
       model.addAttribute("list",list);
       return "UserDetails";

    }
    @GetMapping("/edit")
    public String editForm(@RequestParam Integer id,Model model){
        Users users=userService.getOneUser(id);
        model.addAttribute("users",users);
        return "UserEditForm";
    }
    @PostMapping("/update")
    public String userUpdate(@ModelAttribute Users users){
        userService.updateUser(users);
        return "redirect:All";
    }
    @GetMapping("/delete")
    public String userDelete(@RequestParam Integer id, RedirectAttributes attributes){
        userService.deleteUser(id);
        attributes.addAttribute("message","User'"+id+"' Deleted");
        return  "redirect:All";

    }
    @GetMapping("/search")
    public String searchUsers(@RequestParam String keyword,Model model){
//        System.out.println(keyword);
       List<Users> list= userService.searchUser(keyword);

       model.addAttribute("list",list);
       //model.addAttribute("keyword",keyword);
        //System.out.println(list.size());

       return "UserDetails";

    }
}
