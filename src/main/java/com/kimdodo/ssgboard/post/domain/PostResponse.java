package com.kimdodo.ssgboard.post.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;

    @Builder
    public PostResponse(Long id, String title, String content, LocalDateTime createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }
}
