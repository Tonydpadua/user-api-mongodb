package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.User;
import com.tony.apimongodb.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageUsersServiceImpl implements PageUsersService {


    private final UserRepository userRepository;

    @Override
    public Page<User> pageUsers(Integer page, Integer linesPerPage, String orderBy, String direction) {
        return this.userRepository.findAll(PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy));
    }
}
