package com.kimdodo.ssgboard.post.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private Date createAt;

    @Builder
    public PostResponse(Long id, String title, String content, Date createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }
}
