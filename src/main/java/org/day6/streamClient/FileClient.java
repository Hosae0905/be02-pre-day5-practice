package org.day6.streamClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {
    public static void main(String[] args) throws IOException {
        // 서버와 연결하는 코드
        Socket cs = new Socket("192.168.52.1", 9000);

        // 보내는 코드
        OutputStream os = cs.getOutputStream();
        OutputStreamWriter output = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(output);

        Scanner sc = new Scanner(System.in);
        System.out.print("받고 싶은 파일의 이름을 입력해주세요: ");
        String msg = sc.next();

        bw.write(msg + "\n");
        bw.flush();

        // 받는 코드
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\test2\\" + msg);

        InputStream is = cs.getInputStream();

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        char[] charArray = br.readLine().toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            fileOutputStream.write(charArray[i]);
        }

        fileOutputStream.flush();
        fileOutputStream.close();

    }
}
