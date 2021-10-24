package com.tony.apimongodb.user;

import com.tony.apimongodb.post.Post;
import com.tony.apimongodb.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder(builderClassName = "Builder")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static User from(UserDTO user) {
        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
