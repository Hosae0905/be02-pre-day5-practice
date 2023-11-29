package org.day7.threadTest;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MessageSendThread extends Thread {

    Socket clientSocket;

    public MessageSendThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = clientSocket.getOutputStream();
            OutputStreamWriter output = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(output);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("메시지를 입력해주세요. : ");
                String message = sc.next();

                if (message.contains(".png")) {
                    bw.write(message + "\n");
                    bw.flush();

                    FileInputStream fis = new FileInputStream("C:\\test\\" + message);
                    BufferedOutputStream bos = new BufferedOutputStream(os);

                    int data = 0;
                    while ((data = fis.read()) != -1) {
                        bos.write(data);
                    }

                    bos.flush();
                    fis.close();

                } else {
                    bw.write(message + "\n");
                    bw.flush();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
