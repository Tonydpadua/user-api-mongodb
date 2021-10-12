package com.tony.apimongodb.post.service;

import com.tony.apimongodb.post.Post;
import com.tony.apimongodb.post.PostRepository;
import com.tony.apimongodb.post.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPostByIdServiceImpl implements FindPostByIdService {


    private final PostRepository postRepository;

    @Override
    public Post findById(String postId) {
        return this.postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
    }
}
