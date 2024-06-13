package com.kimdodo.ssgboard.mock;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
public class TestDateHolder implements DateHolder {
    private final LocalDateTime date;

    public TestDateHolder(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = LocalDateTime.parse(date, formatter);
    }

    @Override
    public LocalDateTime getNow() {
        return date;
    }
}
