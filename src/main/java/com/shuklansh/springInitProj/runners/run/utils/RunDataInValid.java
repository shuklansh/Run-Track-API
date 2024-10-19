package com.shuklansh.springInitProj.runners.run.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RunDataInValid extends IllegalArgumentException {
    public RunDataInValid() {
        super("Your RunData is Invalid");
    }
}
