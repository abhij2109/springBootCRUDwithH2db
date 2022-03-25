package com.abhi.h2.service;

import com.abhi.h2.dao.UserRepository;
import com.abhi.h2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        User oldUser=null;
        oldUser=userRepository.findById(user.getId()).get();
        if(oldUser!=null) {
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            userRepository.save(oldUser);
        }
        else{
            return new User();
        }
        return oldUser;
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "User got deleted";
    }
}
