package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running and waiting for connections...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted: " + socket);
                // 创建一个新的线程来处理连接
                Thread thread = new Thread(() -> {
                    try {
                        // 处理连接的业务逻辑
                        handleConnection(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleConnection(Socket socket) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                String request = reader.readLine();
                System.out.println("Received request from client: " + request);
                // 处理请求并发送相应
                String response = "Hello from server!";
                writer.println(response);
                System.out.println("Response sent to client: " + response);
        }
        long id = Thread.currentThread().getId();
        System.out.println("handle connection: " + socket + " " + id);
    }
}
