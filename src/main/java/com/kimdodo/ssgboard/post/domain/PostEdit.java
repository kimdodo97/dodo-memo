package com.kimdodo.ssgboard.post.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostEdit {
    private String title;
    private String content;
    private LocalDateTime createAt;

    @Builder
    public PostEdit(String title, String content, LocalDateTime createAt) {
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }
}
