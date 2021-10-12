package com.tony.apimongodb.user.service;

import com.tony.apimongodb.post.dto.PostDTO;

import java.util.List;

public interface FindUserPostsById {


    List<PostDTO> findUserPostsById(String userId);
}
