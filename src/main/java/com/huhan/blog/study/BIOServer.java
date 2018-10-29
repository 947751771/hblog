package com.huhan.blog.study;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huhan
 * @data 2018/10/20
 */
public class BIOServer {
    /**服务器对外的端口号*/
    private static final Integer PORT = 8888;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        ThreadPoolExecutor executor = null;

        try {
            // ServerSocket 启动监听端口
            server = new ServerSocket(PORT);
            System.out.println("BIO Server 服务器启动.........");

            executor = new ThreadPoolExecutor(10, 100, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50));
            while (true) {
                // 服务器监听：阻塞，等待Client请求
                socket = server.accept();
                ITDragonBIOServerHandler serverHandler = new ITDragonBIOServerHandler(socket);
                executor.execute(serverHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != socket) {
                    socket.close();
                    socket = null;
                }
                if (null != server) {
                    server.close();
                    server = null;
                    System.out.println("BIO Server 服务器关闭了！！！！");
                }
                executor.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
