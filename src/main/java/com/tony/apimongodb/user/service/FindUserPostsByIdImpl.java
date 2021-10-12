package com.tony.apimongodb.user.service;

import com.tony.apimongodb.post.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUserPostsByIdImpl implements FindUserPostsById {


    private final FindUserByIdService findUserByIdService;

    @Override
    public List<PostDTO> findUserPostsById(String userId) {
        List<PostDTO> postsDTO = new ArrayList<>();

        this.findUserByIdService.findById(userId).getPosts()
                .forEach(post -> postsDTO.add(PostDTO.from(post)));
        return postsDTO;
    }
}
