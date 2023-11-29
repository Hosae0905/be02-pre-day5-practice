package org.day6.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamMain2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;   // 한글 처리도 가능함
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("C:\\test\\abc.txt");
            fileWriter = new FileWriter("C:\\test\\abc3.txt");


            while (fileReader.read() != -1) {
                fileWriter.write(fileReader.read());
                System.out.print((char) fileReader.read());
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) fileReader.close();
            if (fileWriter != null) fileWriter.close();
        }
    }
}
