package com.shuklansh.springInitProj.runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run( // Record is immutable BUT has toString(), getters, setters, hashcode()
    @Positive
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    @Positive
    Integer miles,
    Location location
) {
    public Run {
        if (!completedOn.isAfter(startedOn)) {
             throw new IllegalArgumentException("Completed on date cannot be before started on date!");
        }
    }
}
