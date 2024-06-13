package com.kimdodo.ssgboard.post.infrastructure;

import com.kimdodo.ssgboard.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostEntity {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createAt;

    @Builder
    public PostEntity(Long id, String title, String content, LocalDateTime createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }

    public Post toModel(){
        return Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .createAt(createAt)
                .build();
    }

    public static PostEntity fromModel(Post post){
        return PostEntity.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createAt(post.getCreateAt())
                .build();
    }
}
