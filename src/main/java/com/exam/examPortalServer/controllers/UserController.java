package com.exam.examPortalServer.controllers;

import com.exam.examPortalServer.entities.Role;
import com.exam.examPortalServer.entities.User;
import com.exam.examPortalServer.entities.User_Roles;
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

        Set<User_Roles> userRoles = new HashSet<>();
        Role r1 = new Role("Customer");
//        Role r2 = new Role("Admin");

        User_Roles ur = new User_Roles();
        ur.setUser(user);
        ur.setRole(r1);

        userRoles.add(ur);

        return this.userService.createUser(user, userRoles);
    }
    @GetMapping("/{name}")
    public User getUserByUsername(@PathVariable String name) throws BadRequestException {
        return userService.getByUsername(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) throws  BadRequestException{
        return userService.deleteUser(id);
    }
}
