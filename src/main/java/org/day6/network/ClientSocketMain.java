package org.day6.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocketMain {
    public static void main(String[] args) {
        try {
            Socket clientsocket = new Socket("192.168.0.41", 9000);

            OutputStream clientOutputStream = clientsocket.getOutputStream();

            clientOutputStream.write(100);

            InputStream clientInputStream = clientsocket.getInputStream();
            int num = clientInputStream.read();
            System.out.println("num = " + num);

            clientsocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
