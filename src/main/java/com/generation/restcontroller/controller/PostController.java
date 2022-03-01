package com.generation.restcontroller.controller;

import com.generation.restcontroller.model.Post;
import com.generation.restcontroller.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }


}
