package com.nexo.springfeatures.service;

import com.nexo.springfeatures.dto.UserData;

import java.util.List;

public interface UserService {
    UserData getUserById(Long userId);

    UserData saveUser(UserData userData);

    List<UserData> saveUsers(List<UserData> userData);
}
