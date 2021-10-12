package com.tony.apimongodb.post.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {


    private static final long serialVersionUID = 1L;

    private String text;
    private Date date;
    private AuthorDTO author;
}
