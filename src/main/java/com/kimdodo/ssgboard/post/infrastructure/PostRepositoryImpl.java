package com.kimdodo.ssgboard.post.infrastructure;

import com.kimdodo.ssgboard.post.domain.Post;
import com.kimdodo.ssgboard.post.service.port.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostMapper postMapper;

    @Override
    public List<Post> findAll() {
        return postMapper.findAll()
                .stream()
                .map(PostEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postMapper.findById(id).map(PostEntity::toModel);
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public List<Post> findByPage(int size, long offset, boolean asc) {
        return postMapper.findByPage(size,offset,asc)
                .stream()
                .map(PostEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Post> findByContent(String content) {
        return Optional.empty();
    }


    @Override
    public Post save(Post post) {
        PostEntity postEntity = PostEntity.fromModel(post);
        postMapper.save(postEntity);
        return postEntity.toModel();
    }

    @Override
    public Post update(Post post) {
        PostEntity postEntity = PostEntity.fromModel(post);
        postMapper.update(postEntity);
        return postEntity.toModel();
    }

    @Override
    public void delete(Long id) {
        postMapper.delete(id);
    }
}
