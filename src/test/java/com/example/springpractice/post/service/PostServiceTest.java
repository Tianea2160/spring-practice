package com.example.springpractice.post.service;

import com.example.springpractice.post.dto.PostCreateDTO;
import com.example.springpractice.post.dto.PostUpdateDTO;
import com.example.springpractice.post.entity.Post;
import com.example.springpractice.post.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("id를 이용해서 값을 찾으면 PostReadDTO가 반환된다.")
    public void findPostById() {
        // given
        var postId = 1234L;
        var post = new Post(postId, "title", "content");

        given(postRepository.findById(postId)).willReturn(Optional.of(post));

        // when
        var read = postService.findById(postId);

        // then
        assertThat(read.getId()).isEqualTo(post.getId());
        assertThat(read.getContent()).isEqualTo(post.getContent());
        assertThat(read.getTitle()).isEqualTo(post.getTitle());
    }

    @Test
    @DisplayName("post를 수정했을 때 수정된 PostReadDTO가 반환된다.")
    public void updatePost() {
        // given
        var postId = 2345L;
        var update = new PostUpdateDTO("new title", "new content");

        given(postRepository.existsById(postId)).willReturn(true);

        // when
        var read = postService.updatePost(postId, update);

        // then
        assertThat(read.getId()).isEqualTo(postId);
        assertThat(read.getTitle()).isEqualTo(update.getTitle());
        assertThat(read.getContent()).isEqualTo(update.getContent());
    }

    @Test
    @DisplayName("존재하지 않는 post를 수정하려고 하면 IllegalArgumentException이 발생한다.")
    public void updatePostFail() {
        var postId = 1234L;
        var update = new PostUpdateDTO("new title", "new content");
        given(postRepository.existsById(postId)).willReturn(false);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> postService.updatePost(postId, update));
        verify(postRepository, times(1)).existsById(postId);
        verify(postRepository, times(0)).save(any());
    }

    @Test
    @DisplayName("post를 삭제하면 해당 post가 삭제된다.")
    public void deletePost() {
        // given
        var postId = 1234L;

        // when
        postService.deletePost(postId);

        // then
        verify(postRepository, times(1)).deleteById(postId);
    }

    @Test
    @DisplayName("post를 생성하면 해당 post가 생성된다.")
    public void createPost() {
        // given
        var create = new PostCreateDTO("title", "content");
        var post = create.toEntity();
        post.setId(123321L);

        given(postRepository.save(any())).willReturn(post);

        // when
        var read = postService.createPost(create);

        // then
        assertThat(read.getId()).isEqualTo(post.getId());
        assertThat(read.getTitle()).isEqualTo(post.getTitle());
        assertThat(read.getContent()).isEqualTo(post.getContent());
    }

}