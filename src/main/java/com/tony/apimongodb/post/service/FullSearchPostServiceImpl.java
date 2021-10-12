package com.tony.apimongodb.post.service;

import com.tony.apimongodb.post.PostRepository;
import com.tony.apimongodb.post.dto.PostDTO;
import com.tony.apimongodb.util.URLDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FullSearchPostServiceImpl implements FullSearchPostService {


    private final PostRepository postRepository;

    @Override
    public List<PostDTO> fullSearch(String text, String minDate, String maxDate) {
        Date min = URLDecoder.convertDate(minDate, new Date(0L));
        Date max = URLDecoder.convertDate(maxDate, new Date());

        int oneDay = 24 * 60 * 60 * 1000;
        max = new Date(max.getTime() + oneDay);

        List<PostDTO> postsDTO = new ArrayList<>();

        this.postRepository.fullSearch(URLDecoder.decodeParam(text), min, max)
                .forEach(post -> postsDTO.add(PostDTO.from(post)));

        return postsDTO;
    }
}
