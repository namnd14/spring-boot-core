package com.spring.core.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecordExperimentResponse(
        Integer id,
        Long idLong,
        String name,
        LocalDate date,
        LocalDateTime dateTime,
        Boolean isActive
) {
}
