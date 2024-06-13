package com.kimdodo.ssgboard.common.infrastructure;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SystemDateHolder implements DateHolder {
    @Override
    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
