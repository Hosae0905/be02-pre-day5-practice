package org.day6.chatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChattingServer {
    public static void main(String[] args) throws IOException {

        try {
            // 연결하는 코드
            ServerSocket socket = new ServerSocket(9000);
            Socket cs = socket.accept();

            // 받는 코드
            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);
            String data = bir.readLine();
            System.out.println(data);

            // 보내는 코드
            OutputStream os = cs.getOutputStream();
            OutputStreamWriter output = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(output);

            Scanner sc = new Scanner(System.in);
            System.out.print("메세지를 입력해주세요. :");
            String msg = sc.next();

            bw.write(msg + "\n");
            bw.flush();


        } catch (IOException e) {
            e.getMessage();
        }
    }
}
