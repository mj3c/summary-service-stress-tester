package com.example.stress.tester;

import com.example.stress.utils.Post;
import com.example.stress.utils.ResponseHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.AsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
class PostReqTester {
    @Value("${ssst.post_req_endpoint}")
    private String endpoint;

    @Value("${ssst.post_req_num}")
    private int reqNum;

    @Value("${ssst.post_req_pause_in_ms}")
    private int reqPause;

    @Autowired
    private AsyncHttpClient httpClient;

    @Async
    void postSummaries() throws InterruptedException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 1; i <= reqNum; i++) {
            Post post = new Post("[" + i + "] This is a blog post that will be trimmed somewhere.", 32);
            httpClient
                    .preparePost(endpoint)
                    .setHeader("Content-Type", "application/json")
                    .setBody(objectMapper.writeValueAsString(post))
                    .execute(new ResponseHandler("POST", i, reqNum));
            Thread.sleep(reqPause);
        }
    }
}
