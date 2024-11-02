package com.nexo.springfeatures.service;

import com.nexo.springfeatures.dto.UserData;

public interface UserService {
    UserData getUserById(Long userId);

    UserData saveUser(UserData userData);
}
