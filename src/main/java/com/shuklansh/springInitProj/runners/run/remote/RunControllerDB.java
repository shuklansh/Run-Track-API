package com.shuklansh.springInitProj.runners.run.remote;

import com.shuklansh.springInitProj.runners.run.Run;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunControllerDB {
    private final RunRepositoryDB runRepository;

    public RunControllerDB(RunRepositoryDB runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> getAllRuns() {
        return runRepository.getAllRuns();
    }

    /*
    @GetMapping("/{id}")
    Run getRunFromId(@PathVariable Integer id) {
        Optional<Run> output = runRepository.findById(id);
        if (output.isEmpty()) {
*//*            throw new ResponseStatusException(HttpStatus.NO_CONTENT); // could be used later?
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // now we will use specific error*//*
            throw new RunNotFoundException();
        } else {
            return output.get();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void addRunRecord(@RequestBody Run run) {
        runRepository.addRunRecord(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateRunFromId(@RequestBody Run run, @PathVariable Integer id) {
        runRepository.updateRunRecord(run, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteRunFromId(@PathVariable Integer id) {
        runRepository.deleteRunRecordFromId(id);
    }*/
}
