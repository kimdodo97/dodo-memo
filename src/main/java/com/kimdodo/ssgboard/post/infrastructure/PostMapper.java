package com.kimdodo.ssgboard.post.infrastructure;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    Optional<PostEntity> findById(Long id);

    List<PostEntity> findAll();
    Optional<PostEntity> findByTitle(String title);

    List<PostEntity> findByPage(@Param("size") int size, @Param("offset") long offset, @Param("asc") boolean asc);
    Long save(PostEntity postEntity);

    void update(PostEntity postEntity);

    void delete(Long postId);

    void deleteAll();
}
