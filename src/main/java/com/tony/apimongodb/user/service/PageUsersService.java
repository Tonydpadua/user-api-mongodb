package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.User;
import org.springframework.data.domain.Page;

@FunctionalInterface
public interface PageUsersService {

    Page<User> pageUsers(Integer page, Integer linesPerPage, String orderBy, String direction);
}
