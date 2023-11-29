package org.day7.threadServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChattingServer {
    static Map<String, Socket> clientSockets = new HashMap<>();

    public static void main(String[] args) {
        final int SERVER_PORT = 9000;

        try {
            ServerSocket socket = new ServerSocket(SERVER_PORT);

            while (true) {
                Socket clientSocket = socket.accept();

                InputStream is = clientSocket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String id = br.readLine();
                System.out.printf("%s님이 입장하셨습니다.\n", id);     // 수정한 부분

                clientSockets.put(id, clientSocket);

                // 클라이언트 메시지 처리 스레드 생성
                Thread messageThread = new MessageHandlingThread(clientSocket);
                messageThread.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
