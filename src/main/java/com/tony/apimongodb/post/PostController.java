package com.tony.apimongodb.post;

import com.tony.apimongodb.post.dto.PostDTO;
import com.tony.apimongodb.post.service.FindPostByIdService;
import com.tony.apimongodb.post.service.FindPostsByTitleService;
import com.tony.apimongodb.post.service.FullSearchPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/posts")
public class PostController {


    private final FindPostByIdService findPostByIdService;
    private final FindPostsByTitleService findPostsByTitleService;
    private final FullSearchPostService fullSearchPostService;

    @GetMapping(value = "/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO findPostById(@PathVariable String postId) {
        return PostDTO.from(this.findPostByIdService.findById(postId));
    }

    @GetMapping(value = "/titlesearch")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> findPostsByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        return this.findPostsByTitleService.findByTitle(text);
    }

    @GetMapping(value = "/fullsearch")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
            ) {
        return this.fullSearchPostService.fullSearch(text, minDate, maxDate);
    }
}
