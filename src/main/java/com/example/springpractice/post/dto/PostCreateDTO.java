package com.example.springpractice.post.dto;


import com.example.springpractice.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostCreateDTO {
    private String title;
    private String content;

    public Post toEntity(){
        return new Post(title, content);
    }
}
