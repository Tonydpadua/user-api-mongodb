package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.User;

@FunctionalInterface
public interface FindUserByIdService {

    User findById(String userId);
}
