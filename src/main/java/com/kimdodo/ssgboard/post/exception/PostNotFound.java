package com.kimdodo.ssgboard.post.exception;

import com.kimdodo.ssgboard.common.exception.BoardException;

public class PostNotFound extends BoardException {
    private static final String MESSAGE = "존재하는 게시물이 없습니다.";
    public PostNotFound(){
        super(MESSAGE);
    }
    @Override
    public int getStatusCode() {
        return 0;
    }
}
