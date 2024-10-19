package com.shuklansh.springInitProj.runners.run;

import java.time.LocalDateTime;

public record Run( // Record is immutable BUT has toString(), getters, setters, hashcode()
    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    Location location
) {
}
