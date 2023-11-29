package org.day6;

import java.io.*;
import java.net.Socket;

public class WebBrowser {
    public static void main(String[] args) throws IOException {
        Socket cs = new Socket("192.168.0.41", 9000);

        OutputStream os = cs.getOutputStream();
        PrintStream ps = new PrintStream(os);

        ps.println("GET / HTTTP/1.1");
        ps.println("Host: ~~~");
        ps.println();

        BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        String result = null;

        while ((result = br.readLine()) != null) {
            System.out.print(result);
        }

        cs.close();
        ps.close();
        br.close();
    }
}
