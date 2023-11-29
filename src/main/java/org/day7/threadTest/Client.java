package org.day7.threadTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String IP_ADDR = "192.168.52.1";
        final int PORT = 9000;
        Scanner sc = new Scanner(System.in);

        try {
            Socket clientSocket = new Socket(IP_ADDR, PORT);

            OutputStream os = clientSocket.getOutputStream();
            OutputStreamWriter output = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(output);

            System.out.print("ID를 입력해주세요. : ");
            String msg = sc.next();

            bw.write(msg + "\n");
            bw.flush();

            MessageSendThread send = new MessageSendThread(clientSocket);
            send.start();

            MessageReceiveThread receive = new MessageReceiveThread(clientSocket);
            receive.start();

            while (true) {

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
