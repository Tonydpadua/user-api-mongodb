package com.tony.apimongodb.post.service;

import com.tony.apimongodb.post.dto.PostDTO;

import java.util.List;

@FunctionalInterface
public interface FullSearchPostService {

    List<PostDTO> fullSearch(String text, String minDate, String maxDate);
}
