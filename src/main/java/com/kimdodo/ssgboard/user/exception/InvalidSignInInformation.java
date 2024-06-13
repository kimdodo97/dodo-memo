package com.kimdodo.ssgboard.user.exception;

import com.kimdodo.ssgboard.common.exception.BoardException;

public class InvalidSignInInformation extends BoardException {

    private static final String MESSAGE = "아이디/비밀번호가 올바르지 않습니다.";

    public InvalidSignInInformation() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
