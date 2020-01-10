package com.javamentor.revseev.boot.service;

import com.javamentor.revseev.boot.model.User;
import com.javamentor.revseev.boot.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

//CRUD operations:

    /**
     * Do not a saparate updateUser() method as long as this is a transactional service
     * */
    public void saveUser(User user){
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
