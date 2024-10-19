package com.shuklansh.springInitProj.runners.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    // GET
    List<Run> getAllRuns() {
        return runs;
    }

    // GET
    Optional<Run> findById(Integer id) {
        return runs
                .stream()
                .filter( run -> Objects.equals(run.id(), id))
                .findFirst();
    }

    // POST
    void addRunRecord(Run run) {
        runs.add(run);
    }

    // PUT
    void updateRunRecord(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
        /*} else {
            runs.add(run);
        }*/
    }

    // DELETE
    void deleteRunRecordFromId(Integer id) {
        runs.removeIf(run -> Objects.equals(run.id(), id));
    }

    // CREATE DUMMY DATA
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
