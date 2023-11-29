package org.day7.threadTest;

import java.io.*;
import java.net.Socket;

public class MessageReceiveThread extends Thread {
    Socket clientSocket;

    public MessageReceiveThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // 받는 코드
            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);

            while (true) {
                String message = bir.readLine();

                if (message.contains(".png")) {
                    BufferedInputStream bis = new BufferedInputStream(is);
                    FileOutputStream fos = new FileOutputStream("C:\\test2\\" + message);

                    int data = 0;
                    while ((data = bis.read()) != -1) {
                        fos.write(data);
                    }
                    fos.flush();
                    fos.close();
                } else {
                    System.out.println(message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
