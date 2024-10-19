package com.shuklansh.springInitProj.runners.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    // @Autowired -> field injection (NOT recommended)
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) { // constructor (same name as parent class)
        // injects RunRepository in this class because of @Repository annotation on RunRepository
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> getAllRuns() {
        return runRepository.getAllRuns();
    }

    @GetMapping("/{id}")
    Run getRunFromId(@PathVariable Integer id) {
        Optional<Run> output = runRepository.findById(id);
        if (output.isEmpty()) {
/*            throw new ResponseStatusException(HttpStatus.NO_CONTENT); // could be used later?
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); // now we will use specific error*/
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
    }
}
