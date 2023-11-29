package org.day6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {
    public static void main(String[] args) throws IOException {
        // 서버와 연결하는 코드
        Socket cs = new Socket("192.168.0.41", 9000);

        // 보내는 코드
        OutputStream os = cs.getOutputStream();
        OutputStreamWriter output = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(output);

        Scanner sc = new Scanner(System.in);
        System.out.print("원하시는 파일의 이름을 입력해주세요. : ");
        String msg = sc.next();

        bw.write(msg + "\n");
        bw.flush();

        // 받는 코드
        InputStream is = cs.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bir = new BufferedReader(isr);
        String data = bir.readLine();
        System.out.println(data);

        FileInputStream fileInputStream = new FileInputStream("C:\\test2\\" + data);
        fileInputStream.close();
    }
}
