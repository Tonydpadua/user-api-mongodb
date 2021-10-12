package com.tony.apimongodb.user.service;

@FunctionalInterface
public interface DeleteByIdService {

    void deleteById(String userId);
}
