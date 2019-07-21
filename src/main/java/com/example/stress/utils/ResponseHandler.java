package com.example.stress.utils;

import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseHandler implements AsyncHandler<Void> {
    private static final Logger logger = LoggerFactory.getLogger(AsyncHandler.class);

    private String type;
    private int n;
    private int max;
    private int status;

    public ResponseHandler(String type, int n, int max) {
        this.type = type;
        this.n = n;
        this.max = max;
    }

    @Override
    public State onStatusReceived(HttpResponseStatus httpResponseStatus) throws Exception {
        status = httpResponseStatus.getStatusCode();
        return State.ABORT;
    }

    @Override
    public State onHeadersReceived(HttpHeaders httpHeaders) throws Exception {
        return State.ABORT;
    }

    @Override
    public State onBodyPartReceived(HttpResponseBodyPart httpResponseBodyPart) throws Exception {
        return State.ABORT;
    }

    @Override
    public void onThrowable(Throwable throwable) {

    }

    @Override
    public Void onCompleted() throws Exception {
        if (status == 200) {
            logger.info("Succeeded {} request {} / {}", type, n, max);
        }
        return null;
    }
}
