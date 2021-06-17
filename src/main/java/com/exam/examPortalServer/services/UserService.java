package com.exam.examPortalServer.services;

import com.exam.examPortalServer.entities.User;
import com.exam.examPortalServer.entities.User_Roles;
import com.exam.examPortalServer.exception.BadRequestException;
import com.exam.examPortalServer.repository.IRoleRepository;
import com.exam.examPortalServer.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;

    public User createUser(User user, Set<User_Roles> userRoles) throws BadRequestException {
        User userExist = this.userRepository.findByUsername(user.getUsername());
        if(userExist!=null){
           throw new BadRequestException("Username already exists.");
        }
        for(User_Roles ur : userRoles){
            this.roleRepository.save(ur.getRole());
        }
        user.getUserRoles().addAll(userRoles);
        return this.userRepository.save(user);
    }
    public User getByUsername(String name) throws BadRequestException {
        User user = userRepository.findByUsername(name);
        if(user==null)
            throw new BadRequestException("No such user exist");
        return user;
    }

    public String deleteUser(Long id) throws BadRequestException {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new BadRequestException("No such user exist");
        userRepository.delete(user.get());
        return "User Deleted";
    }
}
