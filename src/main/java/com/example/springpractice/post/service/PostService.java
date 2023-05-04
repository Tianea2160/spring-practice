package com.example.springpractice.post.service;

import com.example.springpractice.post.dto.PostCreateDTO;
import com.example.springpractice.post.dto.PostReadDTO;
import com.example.springpractice.post.dto.PostUpdateDTO;
import com.example.springpractice.post.entity.Post;
import com.example.springpractice.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    /*
    @RequiredArgsConstructor 이 어노테이션은 final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어준다.
    따라서 아래의 코드를 자동 생성하는 것과 같다.

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    */

    @Transactional
    public PostReadDTO createPost(PostCreateDTO create) {
        Post post = create.toEntity();
        postRepository.save(post);
        return PostReadDTO.from(post);
    }

    @Transactional(readOnly = true)
    public PostReadDTO findById(Long postId) {
        Post post =  postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + postId));
        return PostReadDTO.from(post);
    }

    @Transactional
    public PostReadDTO updatePost(Long postId, PostUpdateDTO update) {
        Post post = update.toEntity();
        post.setId(postId);
        postRepository.save(post);
        return PostReadDTO.from(post);
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
