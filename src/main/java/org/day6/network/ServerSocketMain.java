package org.day6.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {
    public static void main(String[] args) {
        // 소켓은 네트워크 스트림

        try {
            // 특정 포트번호를 리슨으로 바꿔준다
            ServerSocket serverSocket =  new ServerSocket(9000);    // server

            Socket clientSocket = serverSocket.accept();      // client

            System.out.println(clientSocket.getInetAddress() + "접속함.");

            InputStream clientInputStream = clientSocket.getInputStream();

            int num = clientInputStream.read();
            System.out.println("num = " + num);

            OutputStream clientOutputStream = clientSocket.getOutputStream();
            clientOutputStream.write(200);

            serverSocket.close();
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
