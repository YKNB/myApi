package com.vkstech.elasticsearch.converter;

import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;
import org.springframework.core.convert.converter.Converter;

public class LongToLocalDateConverter implements Converter<Long, LocalDate> {

    @Override
    public LocalDate convert(Long source) {
        Instant instant = Instant.ofEpochMilli(source);
        return instant.atZone(ZoneId.of("UTC")).toLocalDate();
    }
}


