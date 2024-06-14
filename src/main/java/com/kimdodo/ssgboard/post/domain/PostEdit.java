package com.kimdodo.ssgboard.post.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class PostEdit {
    private String title;
    private String content;
    private Date createAt;

    @Builder
    public PostEdit(String title, String content, Date createAt) {
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }
}
