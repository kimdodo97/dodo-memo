package com.kimdodo.ssgboard.post.service;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import com.kimdodo.ssgboard.post.domain.Post;
import com.kimdodo.ssgboard.post.domain.PostCreate;
import com.kimdodo.ssgboard.post.domain.PostEdit;
import com.kimdodo.ssgboard.post.domain.PostSearch;
import com.kimdodo.ssgboard.post.exception.PostNotFound;
import com.kimdodo.ssgboard.post.service.port.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final DateHolder dateHolder;
    @Override
    @Transactional(readOnly = true)
    public Post get(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFound::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getByTitle(String title) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getList(PostSearch postSearch) {
        return postRepository.findByPage(postSearch.getPage(),postSearch.getOffset(), postSearch.isAsc());
    }

    @Override
    public Long write(PostCreate postCreate) {
        Post post = postRepository.save(Post.from(postCreate, dateHolder));
        return post.getId();
    }

    @Override
    public Post edit(Long id, PostEdit postEdit) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFound::new);
        post = post.edit(postEdit);
        return postRepository.update(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.delete(id);
    }
}
