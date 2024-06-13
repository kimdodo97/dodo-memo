package com.kimdodo.ssgboard.post.service.port;

import com.kimdodo.ssgboard.post.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<Post> findAll();
    Optional<Post> findById(Long id);
    Optional<Post> findByTitle(String title);
    Optional<Post> findByContent(String content);
    List<Post> findByPage(int size, long offset, boolean asc);
    Post save(Post post);
    Post update(Post post);
    void delete(Long id);
}
