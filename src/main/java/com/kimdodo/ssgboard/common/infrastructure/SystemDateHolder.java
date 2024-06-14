package com.kimdodo.ssgboard.common.infrastructure;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class SystemDateHolder implements DateHolder {
    @Override
    public Date getNow() {
        return Date.from(Instant.now());
    }
}
