package com.shuklansh.springInitProj.runners.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return runRepository.findById(id);
    }
}
