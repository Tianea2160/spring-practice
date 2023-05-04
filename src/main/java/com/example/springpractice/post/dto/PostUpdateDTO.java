package com.example.springpractice.post.dto;


import com.example.springpractice.post.entity.Post;
import lombok.Data;

@Data
public class PostUpdateDTO {
    private String title;
    private String content;

    public Post toEntity(){
        return new Post(title, content);
    }
}
