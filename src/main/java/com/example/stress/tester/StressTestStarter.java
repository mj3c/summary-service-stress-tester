package com.example.stress.tester;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StressTestStarter {
    @Autowired
    private PostReqTester postReqTester;

    @Autowired
    private GetReqTester getReqTester;

    @PostConstruct
    private void startTesters() throws JsonProcessingException, InterruptedException {
        postReqTester.postSummaries();
        getReqTester.getSummaries();
    }
}
