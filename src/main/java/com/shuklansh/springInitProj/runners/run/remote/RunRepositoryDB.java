package com.shuklansh.springInitProj.runners.run.remote;

import com.shuklansh.springInitProj.runners.Application;
import com.shuklansh.springInitProj.runners.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RunRepositoryDB {
    private final JdbcClient jdbcClient;
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public RunRepositoryDB(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> getAllRuns() {
        return jdbcClient.sql("select * from run")
                .query(Run.class)
                .list();
    }

}
