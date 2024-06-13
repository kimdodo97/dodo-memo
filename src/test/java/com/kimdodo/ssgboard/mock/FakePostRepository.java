package com.kimdodo.ssgboard.mock;

import com.kimdodo.ssgboard.post.domain.Post;
import com.kimdodo.ssgboard.post.service.port.PostRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakePostRepository implements PostRepository {
    private final AtomicLong autoGenerateId = new AtomicLong(0);
    private final List<Post> data = Collections.synchronizedList(new ArrayList<>());
    @Override
    public List<Post> findAll() {
        return data;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return data.stream().filter(item -> item.getId().equals(id)).findAny();
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Optional<Post> findByContent(String content) {
        return Optional.empty();
    }

    @Override
    public List<Post> findByPage(int size, long offset, boolean desc) {
        return null;
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
