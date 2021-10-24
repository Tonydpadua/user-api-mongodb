package com.tony.apimongodb.user;

public class UserBuilder {


    public static User.Builder createUser() {
        return User.builder()
                .id("12345")
                .name("User 1")
                .email("user@email.com");
    }
}
