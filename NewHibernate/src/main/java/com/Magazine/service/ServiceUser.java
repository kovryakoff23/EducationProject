package com.Magazine.service;

import com.Magazine.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Magazine.repository.UserRepository;

import java.util.List;
@Service
public class ServiceUser implements ServiceMag<User> {
    @Autowired
    UserRepository userRepository;
    @Override
    public User get(long userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void delete(long userId) {
        userRepository.deleteById(userId);
    }
}
