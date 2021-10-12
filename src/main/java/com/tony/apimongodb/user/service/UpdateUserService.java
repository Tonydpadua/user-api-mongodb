package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.User;
import com.tony.apimongodb.user.dto.UserDTO;

@FunctionalInterface
public interface UpdateUserService {

    UserDTO updateUser(User user, String userId);
}
