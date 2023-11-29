package org.day6.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamMain3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);

        try {
            fileInputStream = new FileInputStream("C:\\test\\abc.txt");

            while (bis.read() != -1) {
                System.out.print((char) bis.read());
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) fileInputStream.close();
            if (bis != null) bis.close();
        }
    }
}
