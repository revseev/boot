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
    public String toIndex() {
        return "index";
    }

    @GetMapping(value = "/list")
    public String toList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping(value = "/new")
    public String toUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "userform";
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
    public String toEditForm(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("edit", true);
        return "userform";
    }
}
