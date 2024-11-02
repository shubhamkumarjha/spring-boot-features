package com.nexo.springfeatures.service.impl;

import com.nexo.springfeatures.dao.User;
import com.nexo.springfeatures.dto.UserData;
import com.nexo.springfeatures.repository.UserRepository;
import com.nexo.springfeatures.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserData getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(user -> this.modelMapper.map(user, UserData.class)).orElse(null);
    }

    @Override
    @Transactional
    public UserData saveUser(UserData userData) {
        User user =this.modelMapper.map(userData,User.class);
        user = userRepository.save(user);
        return this.modelMapper.map(user, UserData.class);
    }
}
