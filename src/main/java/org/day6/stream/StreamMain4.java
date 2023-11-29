package org.day6.stream;

import java.io.*;

public class StreamMain4 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;   // 한글 처리도 가능함
        FileWriter fileWriter = null;
        BufferedReader br = null;

        try {
            fileReader = new FileReader("C:\\test\\abc.txt");
            fileWriter = new FileWriter("C:\\test\\abc3.txt");

            br = new BufferedReader(fileReader);

            while (br.read() != -1) {
                fileWriter.write(br.read());
                System.out.print((char) br.read());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) fileReader.close();
            if (fileWriter != null) fileWriter.close();
        }
    }
}
