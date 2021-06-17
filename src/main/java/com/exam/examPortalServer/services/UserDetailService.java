package com.exam.examPortalServer.services;

import com.exam.examPortalServer.entities.User;
import com.exam.examPortalServer.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found!!!");
        }
        return user;
    }
}
