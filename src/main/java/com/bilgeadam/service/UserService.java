package com.bilgeadam.service;


import com.bilgeadam.dto.request.UserResgisterRequestDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    private IUserRepository userRepository;

    public User createUser(String name, String surName, String password, String email) {
        User user= User.builder()
                .name(name)
                .surName(surName)
                .password(password)
                .email(email)
                .build();
        return userRepository.save(user);
    }

    public User register(UserResgisterRequestDto dto) {
        User user= User.builder()
                .name(dto.getName())
                .surName(dto.getSurName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        return  userRepository.save(user);
    }


    public User register2(UserResgisterRequestDto dto) {
        User user= IUserMapper.INSTANCE.toUser(dto);
        return userRepository.save(user);
    }
}
