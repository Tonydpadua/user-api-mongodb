package com.tony.apimongodb.post.exception;

public class PostNotFoundException extends RuntimeException {

    private static final long serialVersionUID=1L;

    public PostNotFoundException(String userId) {
        super("Post not found for id: " + userId);
    }
}
