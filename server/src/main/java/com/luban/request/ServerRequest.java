package com.luban.request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerRequest {
    public void publishServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        while (true){
            System.out.println("wait conn");
            Socket accept = serverSocket.accept();
            executorService.execute(new ServerHandler(accept));
            System.out.println("seccess conn");
        }

    }
}
