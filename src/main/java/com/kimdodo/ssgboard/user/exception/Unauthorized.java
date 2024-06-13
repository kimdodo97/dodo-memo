package com.kimdodo.ssgboard.user.exception;

import com.kimdodo.ssgboard.common.exception.BoardException;

/**
 * status -> 401
 */
public class Unauthorized extends BoardException {

    private static final String MESSAGE = "인증이 필요합니다.";

    public Unauthorized() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 401;
    }
}
