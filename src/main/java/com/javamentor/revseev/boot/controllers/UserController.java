package com.javamentor.revseev.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.javamentor.revseev.boot.model.Role;
import com.javamentor.revseev.boot.model.User;
import com.javamentor.revseev.boot.service.RoleService;
import com.javamentor.revseev.boot.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping
    public ModelAndView toIndex() {
        return new ModelAndView("index");
    }

    @GetMapping(value = "/list")
    public ModelAndView toList() {
        return new ModelAndView("user-list")
                .addObject("users", userService.getAllUsers());
    }

    @GetMapping(value = "/new")
    public ModelAndView toUserForm() {
        return new ModelAndView("userform")
                .addObject("user", new User())
                .addObject("edit", false);
    }

    @ModelAttribute("allRoles")
    public List<Role> initializeProfiles() {
        return roleService.getAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/list";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView toEditForm(@RequestParam(value = "id") long id) {
        return new ModelAndView("userform")
                .addObject("user", userService.findById(id))
                .addObject("edit", true);

    }
}
