package com.bilgeadam.controller;


import com.bilgeadam.dto.request.UserResgisterRequestDto;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    /*
        @RequestParam()=> default olarak parametreyi zorunlu hale getiriri ve
        o parametreye özellikler kazandırır

     */

    @GetMapping("/save")
    public ResponseEntity<User> createUser(String name, String surName, @RequestParam Optional<String> password, @RequestParam(defaultValue ="example@gmail.com") String email){
            String mypassword=null;
        if (password.isPresent()){
                mypassword=password.get();
            }
        return ResponseEntity.ok(userService.createUser(name,surName,mypassword,email));
    }

    @GetMapping("/register")
    public ResponseEntity<User> register(UserResgisterRequestDto dto){
        return ResponseEntity.ok(userService.register2(dto));
    }

    @PostMapping("/register2")
    public ResponseEntity<User> register2(@RequestBody UserResgisterRequestDto dto){
        return ResponseEntity.ok(userService.register2(dto));
    }





}
