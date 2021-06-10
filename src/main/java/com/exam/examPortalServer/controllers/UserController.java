package com.exam.examPortalServer.controllers;

import com.exam.examPortalServer.entities.Role;
import com.exam.examPortalServer.entities.User;
import com.exam.examPortalServer.exception.BadRequestException;
import com.exam.examPortalServer.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User createUser(@RequestBody User user) throws BadRequestException {

        Set<Role> userroles = new HashSet<>();
        Role role = new Role();
        role.setRoleName("Customer");
        Role r = new Role("Admin");
        userroles.add(role);
        userroles.add(r);

        return this.userService.createUser(user, userroles);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) throws BadRequestException {
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) throws  BadRequestException{
        return userService.deleteUser(id);
    }
}
