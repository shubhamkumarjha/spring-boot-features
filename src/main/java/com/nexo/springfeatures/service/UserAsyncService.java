package com.nexo.springfeatures.service;

import com.nexo.springfeatures.dto.UserData;

import java.util.concurrent.CompletableFuture;

public interface UserAsyncService {
    CompletableFuture<UserData> saveUser(UserData userData);
}
