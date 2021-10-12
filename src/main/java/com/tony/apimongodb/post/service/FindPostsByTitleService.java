package com.tony.apimongodb.post.service;

import com.tony.apimongodb.post.dto.PostDTO;

import java.util.List;

@FunctionalInterface
public interface FindPostsByTitleService {


    List<PostDTO> findByTitle(String text);
}
