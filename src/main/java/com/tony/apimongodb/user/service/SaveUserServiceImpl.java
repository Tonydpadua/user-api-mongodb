package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.User;
import com.tony.apimongodb.user.UserRepository;
import com.tony.apimongodb.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveUserServiceImpl implements SaveUserService {


    private final UserRepository userRepository;

    @Override
    public UserDTO save(User user) {
        return UserDTO.from(this.userRepository.save(user));
    }
}
