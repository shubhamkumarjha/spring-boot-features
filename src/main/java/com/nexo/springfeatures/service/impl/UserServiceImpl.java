package com.nexo.springfeatures.service.impl;

import com.nexo.springfeatures.dao.User;
import com.nexo.springfeatures.dto.UserData;
import com.nexo.springfeatures.repository.UserRepository;
import com.nexo.springfeatures.service.UserAsyncService;
import com.nexo.springfeatures.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserAsyncServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserAsyncService userAsyncService;

    @Override
    public UserData getUserById(Long userId) {
        logger.info("UserServiceImpl Fetching user by id :: {}", userId);
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElse(null);
        logger.info("UserServiceImpl Fetched user :: {}", user);
        return this.modelMapper.map(user, UserData.class);
    }

    @Override
    @Transactional
    public UserData saveUser(UserData userData) {
        logger.info("UserServiceImpl Saving UserData :: {}", userData);
        User user =this.modelMapper.map(userData,User.class);
        user = userRepository.save(user);
        logger.info("UserServiceImpl Saved user in DB :: {}", user);
        return this.modelMapper.map(user, UserData.class);
    }

    @Override
    public List<UserData> saveUsers(List<UserData> usersData) {
        logger.info("UserServiceImpl saveUsers usersData :: {}",usersData);
        List<CompletableFuture<UserData>> futures  = usersData.stream()//Streaming through user data list
                // mapping each userdata and passing it to saveUser and expecting by using supplyAsync method return CompletableFuture<T> obects
                .map(userData -> CompletableFuture.supplyAsync(() -> userAsyncService.saveUser(userData)))
                .map(CompletableFuture::join)//Mapping each CompletableFuture<UserData> to join
                .toList();
        return futures.stream().map(u-> {
            try {
                return u.get();//CompleableFuture<T> get() return T object
            } catch (InterruptedException e) {
                logger.error("InterruptedException :: {}",e.getMessage());
            } catch (ExecutionException e) {
                logger.error("ExecutionException :: {}",e.getMessage());
            }
            return null;
        }).toList();
    }

}
