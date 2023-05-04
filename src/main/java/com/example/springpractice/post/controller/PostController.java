package com.example.springpractice.post.controller;


import com.example.springpractice.post.dto.PostCreateDTO;
import com.example.springpractice.post.dto.PostReadDTO;
import com.example.springpractice.post.dto.PostUpdateDTO;
import com.example.springpractice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public PostReadDTO findByID(@PathVariable Long postId) {
        return postService.findById(postId);
    }

    @PostMapping
    public PostReadDTO createPost(@RequestBody PostCreateDTO create) {
        return postService.createPost(create);
    }

    @PutMapping("/{postId}")
    public PostReadDTO updatePost(
            @PathVariable Long postId,
            @RequestBody PostUpdateDTO update
    ) {
        return postService.updatePost(postId, update);
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return "delete success";
    }
}
