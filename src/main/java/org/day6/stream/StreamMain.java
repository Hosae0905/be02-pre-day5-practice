package org.day6.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamMain {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("C:\\test\\abc.txt");
            fileOutputStream = new FileOutputStream("C:\\test\\abc4.txt");

            byte[] bytes = fileInputStream.readAllBytes();

            for (int i = 0; i < bytes.length; i++) {
                fileOutputStream.write(bytes[i]);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) fileInputStream.close();
            if (fileOutputStream != null) fileOutputStream.close();
        }
    }
}
