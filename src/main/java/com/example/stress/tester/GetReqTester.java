package com.example.stress.tester;

import com.example.stress.utils.ResponseHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
class GetReqTester {
    @Value("${ssst.get_req_endpoint}")
    private String endpoint;

    @Value("${ssst.get_req_num}")
    private int reqNum;

    @Value("${ssst.get_req_pause_in_ms}")
    private int reqPause;

    @Autowired
    private AsyncHttpClient httpClient;

    @Async
    void getSummaries() throws InterruptedException {
        for (int i = 1; i <= reqNum; i++) {
            httpClient
                    .prepareGet(endpoint)
                    .execute(new ResponseHandler("GET", i, reqNum));
            Thread.sleep(reqPause);
        }
    }
}
