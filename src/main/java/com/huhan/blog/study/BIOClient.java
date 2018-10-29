package com.huhan.blog.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * @author huhan
 * @data 2018/10/20
 */
public class BIOClient {
    private static Integer PORT = 8888;
    private static String IP_ADDRESS = "127.0.0.1";
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            clientReq(i);
        }
    }
    private static void clientReq(int i) {
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            // Socket 发起连接操作。连接成功后，双方通过输入和输出流进行同步阻塞式通信
            socket = new Socket(IP_ADDRESS, PORT);
            // 获取返回内容
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            String[] operators = {"+","-","*","/"};
            Random random = new Random(System.currentTimeMillis());
            String expression = random.nextInt(10)+operators[random.nextInt(4)]+(random.nextInt(10)+1);
            // 向服务器端发送数据
            writer.println(expression);
            System.out.println(i + " 客户端打印返回数据 : " + reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
                if (null != socket) {
                    socket.close();
                    socket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
