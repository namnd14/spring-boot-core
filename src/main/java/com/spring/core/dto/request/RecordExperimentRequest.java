package com.spring.core.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecordExperimentRequest(
        Integer id,
        Long idLong,
        String name,
        LocalDate date,
        LocalDateTime dateTime,
        Boolean isActive
) {
}
