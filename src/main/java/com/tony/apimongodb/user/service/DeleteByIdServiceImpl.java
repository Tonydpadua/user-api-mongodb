package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteByIdServiceImpl implements DeleteByIdService {


    private final UserRepository userRepository;
    private final FindUserByIdService findUserByIdService;

    @Override
    public void deleteById(String userId) {
        this.findUserByIdService.findById(userId);

        this.userRepository.deleteById(userId);
    }
}
