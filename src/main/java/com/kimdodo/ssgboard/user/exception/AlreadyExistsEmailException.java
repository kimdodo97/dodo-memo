package com.kimdodo.ssgboard.user.exception;

import com.kimdodo.ssgboard.common.exception.BoardException;

public class AlreadyExistsEmailException extends BoardException {

    private static final String MESSAGE = "이미 가입된 이메일입니다.";

    public AlreadyExistsEmailException() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
