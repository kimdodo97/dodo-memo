package com.kimdodo.ssgboard.mock;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestDateHolder implements DateHolder {
    private final Date date;

    public TestDateHolder(Date date){
        this.date = date;
    }

    @Override
    public Date getNow() {
        return date;
    }
}
