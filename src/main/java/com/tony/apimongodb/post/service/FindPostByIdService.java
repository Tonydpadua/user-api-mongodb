package com.tony.apimongodb.post.service;

import com.tony.apimongodb.post.Post;

@FunctionalInterface
public interface FindPostByIdService {

    Post findById(String postId);
}
