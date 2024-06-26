package com.kimdodo.ssgboard.post.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostSearch {
    private static final int MAX_SIZE = 2000;

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    @Builder.Default
    private boolean asc = false;

    public long getOffset(){
        return (long)(Math.max(1,page)-1)*Math.min(size,MAX_SIZE);
    }
}
