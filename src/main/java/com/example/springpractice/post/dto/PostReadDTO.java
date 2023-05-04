package com.example.springpractice.post.dto;

import com.example.springpractice.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PostReadDTO {
    private Long id;
    private String title;
    private String content;

    public static PostReadDTO from(Post post){
        return new PostReadDTO(post.getId(), post.getTitle(), post.getContent());
    }
}
