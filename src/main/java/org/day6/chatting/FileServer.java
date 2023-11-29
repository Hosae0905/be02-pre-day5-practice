package org.day6.chatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {

        try {
            // 연결하는 코드
            ServerSocket socket = new ServerSocket(9000);
            Socket cs = socket.accept();

            // 받는 코드
            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bir = new BufferedReader(isr);
            String filename = bir.readLine();
            System.out.println(filename);

            FileInputStream input = new FileInputStream("C:\\test\\" + filename);

            // 보내는 코드
            OutputStream os = cs.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);

            int data1 = 0;
            while ((data1 = input.read()) != -1) {
                bos.write(data1);
            }

            bos.flush();
            bos.close();
            input.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
