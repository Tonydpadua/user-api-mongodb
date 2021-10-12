package com.tony.apimongodb.post.service;

import com.tony.apimongodb.post.Post;
import com.tony.apimongodb.post.PostRepository;
import com.tony.apimongodb.post.dto.PostDTO;
import com.tony.apimongodb.util.URLDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPostsByTitleServiceImpl implements FindPostsByTitleService {


    private final PostRepository postRepository;

    @Override
    public List<PostDTO> findByTitle(String text) {
        List<PostDTO> postsDTO = new ArrayList<>();

        this.postRepository.findByTitleContainingIgnoreCase(URLDecoder.decodeParam(text))
                .forEach(post -> postsDTO.add(PostDTO.from(post)));

        return postsDTO;
    }
}
