package com.kimdodo.ssgboard.post.domain;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;


@Getter
public class Post {
    private Long id;
    private String title;
    private String content;
    private Date createAt;

    @Builder
    public Post(Long id, String title, String content, Date createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }

    public static Post from(PostCreate postCreate, DateHolder dateHolder){
        return Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .createAt(dateHolder.getNow())
                .build();
    }

    public Post edit(PostEdit postEdit){
        return builder()
                .id(id)
                .title(postEdit.getTitle() != null ? postEdit.getTitle() : this.title)
                .content(postEdit.getContent() != null ? postEdit.getContent() : this.content)
                .createAt(createAt)
                .build();
    }

    public PostResponse toResponse(){
        return PostResponse.builder()
                .id(id)
                .title(title)
                .content(content)
                .createAt(createAt)
                .build();
    }
}
