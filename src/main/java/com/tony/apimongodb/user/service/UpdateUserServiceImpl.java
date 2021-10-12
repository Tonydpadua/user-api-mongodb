package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.User;
import com.tony.apimongodb.user.UserRepository;
import com.tony.apimongodb.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserServiceImpl implements UpdateUserService {


    private final UserRepository userRepository;
    private final FindUserByIdService findUserByIdService;

    @Override
    public UserDTO updateUser(User user, String userId) {
        User userDB = this.findUserByIdService.findById(userId);
        this.updateDBUser(userDB, user, userId);

        return UserDTO.from(this.userRepository.save(userDB));
    }

    private void updateDBUser(User userDB, User user, String userId) {
        userDB.setId(userId);
        userDB.setName(user.getName());
        userDB.setEmail(user.getEmail());
    }
}
