package com.tony.apimongodb.post.dto;

import com.tony.apimongodb.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO implements Serializable {


    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public static AuthorDTO from(User user) {
        return AuthorDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
