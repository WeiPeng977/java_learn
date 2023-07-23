package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            // 发送请求
            String request = "Hello from client!";
            writer.println(request);
            System.out.println("Request sent to server: " + request);

            // 接收响应
            String response = reader.readLine();
            System.out.println("Received response from server: " + response);
        }
    }
}
