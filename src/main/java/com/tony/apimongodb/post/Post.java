package com.tony.apimongodb.post;

import com.tony.apimongodb.post.dto.AuthorDTO;
import com.tony.apimongodb.post.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document
public class Post implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private Date date;

    private String title;

    private String body;

    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

}
