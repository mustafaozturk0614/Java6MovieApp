package com.bilgeadam.service;


import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.UserResgisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IServiceCrud<User> {
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

    public List<User> findAllByOrderByName(){
        return userRepository.findAllByOrderByName();
    }

    public   List<User> findByNameContainingIgnoreCase(String value){
        return userRepository.findByNameContainingIgnoreCase(value);
    }
    public   List<User> findByEmailContainingIgnoreCase(String value){
        return userRepository.findByEmailContainingIgnoreCase(value);
    }
    public   List<User> findByEmailEndingWith(String value){
        return userRepository.findByEmailEndingWith(value);
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<User> user=userRepository.findOptionalByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if (user.isEmpty()){
            throw new RuntimeException("Boyle bir kullancı bulunamadı");
        }
        return IUserMapper.INSTANCE.toLoginResponseDto(user.get());
    }
    public    List<User> passwordLongerThan(int value){
        return userRepository.passwordLongerThan(value);
    }
    public    List<User> passwordLongerThan2(int value){
        return userRepository.passwordLongerThan2(value);
    }
    public    List<User> passwordLongerThan3(int value){
        return userRepository.passwordLongerThan3(value);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return userRepository.saveAll(t);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
}
