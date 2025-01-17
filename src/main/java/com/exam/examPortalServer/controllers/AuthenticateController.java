package com.exam.examPortalServer.controllers;

import com.exam.examPortalServer.request.JwtRequest;
import com.exam.examPortalServer.response.JwtResponse;
import com.exam.examPortalServer.services.UserDetailService;
import com.exam.examPortalServer.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtUtils jwtUtils;

    //generate token
    @PostMapping("/generate_token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found");
        }

        //if Authenticated
        UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return  ResponseEntity.ok(new JwtResponse(token));

    }
    public void authenticate(String username , String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw new Exception("User Disabled" + e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials" + e.getMessage());
        }
    }
}
