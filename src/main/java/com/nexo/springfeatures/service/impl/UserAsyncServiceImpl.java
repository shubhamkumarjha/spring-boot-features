package com.nexo.springfeatures.service.impl;

import com.nexo.springfeatures.dao.User;
import com.nexo.springfeatures.dto.UserData;
import com.nexo.springfeatures.repository.UserRepository;
import com.nexo.springfeatures.service.UserAsyncService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service("UserAsyncServiceImpl")
public class UserAsyncServiceImpl implements UserAsyncService {

    private static final Logger logger = LoggerFactory.getLogger(UserAsyncServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Async
    @Override
    @Transactional
    public CompletableFuture<UserData> saveUser(UserData userData) {
        logger.info("UserAsyncServiceImpl Saving UserData :: {}", userData);
        User user =this.modelMapper.map(userData,User.class);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        user = userRepository.save(user);
        logger.info("UserAsyncServiceImpl Saved user in DB :: {}", user);
        return CompletableFuture.completedFuture(this.modelMapper.map(user, UserData.class));
    }

}
