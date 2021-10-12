package com.tony.apimongodb.post.dto;

import com.tony.apimongodb.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {


    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private String id;

    private Date date;

    private String title;

    private String body;

    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

    public static PostDTO from(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .date(post.getDate())
                .title(post.getTitle())
                .body(post.getBody())
                .author(post.getAuthor())
                .comments(post.getComments())
                .build();
    }
}
