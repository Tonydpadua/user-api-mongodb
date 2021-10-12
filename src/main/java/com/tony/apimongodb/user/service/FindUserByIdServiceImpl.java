package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.User;
import com.tony.apimongodb.user.UserRepository;
import com.tony.apimongodb.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByIdServiceImpl implements FindUserByIdService {


    private final UserRepository userRepository;

    @Override
    public User findById(String userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }
}
