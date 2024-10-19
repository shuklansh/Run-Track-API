package com.shuklansh.springInitProj.runners.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> getAllRuns() {
        return runs;
    }

    Run findById(Integer id) {
        return runs
                .stream()
                .filter( run -> Objects.equals(run.id(), id))
                .findFirst()
                .get();
    }

    @PostConstruct
    private void init() {
        runs.add(
            new Run(
                1,
                "run in gym",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                2,
                Location.INDOOR
            )
        );
        runs.add(
            new Run(
                2,
                "run from and to gym",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                2,
                Location.OUTDOOR
            )
        );
        runs.add(
            new Run(
                3,
                "Runner David",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                5,
                Location.OUTDOOR
            )
        );
    }
}
