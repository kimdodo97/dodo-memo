package com.kimdodo.ssgboard.post.service;

import com.kimdodo.ssgboard.post.domain.Post;
import com.kimdodo.ssgboard.post.domain.PostCreate;
import com.kimdodo.ssgboard.post.domain.PostEdit;
import com.kimdodo.ssgboard.post.domain.PostSearch;

import java.util.List;

public interface PostService {
    Post get(Long id);
    List<Post> getByTitle(String title);

    List<Post> getList(PostSearch postSearch);
    Long write(PostCreate postCreate);

    Post edit(Long id, PostEdit postEdit);

    void delete(Long id);
}
