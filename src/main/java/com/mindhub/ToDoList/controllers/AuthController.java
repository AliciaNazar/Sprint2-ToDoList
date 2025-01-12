package com.mindhub.ToDoList.controllers;


import com.mindhub.ToDoList.config.JwtUtils;
import com.mindhub.ToDoList.dtos.LoginUserDTO;
import com.mindhub.ToDoList.models.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginUserDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate( //usando el authenticationManager
                new UsernamePasswordAuthenticationToken(               //valido la información del usuario
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtil.generateToken(authentication.getName());
        String username = authentication.getName();
        RoleType role = authentication.getAuthorities().stream()
                .findFirst()
                .map(grantedAuthority -> RoleType.valueOf(grantedAuthority.getAuthority()))
                .orElseThrow(() -> new RuntimeException("No role found"));
        String jwt = jwtUtil.generateToken(username, role);
        return ResponseEntity.ok(jwt);
    }


    //registro


}