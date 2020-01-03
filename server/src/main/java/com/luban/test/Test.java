package com.luban.test;

import com.luban.request.ServerRequest;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ServerRequest serverRequest = new ServerRequest();
        serverRequest.publishServer();
    }
}
