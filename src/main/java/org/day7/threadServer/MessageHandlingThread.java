package org.day7.threadServer;

import java.io.*;
import java.net.Socket;

public class MessageHandlingThread extends Thread{

    Socket clientSocket;


    public MessageHandlingThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedInputStream bis = new BufferedInputStream(is);  // 추가한 코드
            BufferedReader bir = new BufferedReader(isr);

            while (true) {      // 추가한 코드
                String message = bir.readLine();

                if (message.contains(".png")) {
                for (String key : ChattingServer.clientSockets.keySet()) {

                    Socket client = ChattingServer.clientSockets.get(key);
                    OutputStream os = client.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write(message + "\n");
                    bw.flush();

                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    int data = 0;
                    while ((data = bis.read()) != -1) {
                        bos.write(data);
                    }

                    bos.flush();
                    }
                } else {
                    for (String key : ChattingServer.clientSockets.keySet()) {

                        Socket client = ChattingServer.clientSockets.get(key);
                        OutputStream os = client.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        BufferedWriter bw = new BufferedWriter(osw);
                        bw.write(message + "\n");
                        bw.flush();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("클라이언트와 접속이 끊겼습니다.");
            throw new RuntimeException(e);
        }
    }
}
