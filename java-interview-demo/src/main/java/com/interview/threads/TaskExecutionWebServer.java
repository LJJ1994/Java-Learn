package com.interview.threads;

import java.io.FileFilter;
import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        System.out.println("server running....");
        while (true){
            Socket accept = socket.accept();
            Runnable task = new Runnable(){
                @Override
                public void run() {
                    handlerRequest(accept);
                }
            };
            exec.execute(task);
        }
    }
    private static void handlerRequest(Socket socket){
        System.out.println("address: " + socket.getInetAddress());
    }
}
