package Lesson_3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

class PrimitiveReaderMain {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("test\\1.txt", "r");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int sheet = 1800;
            String numberOfSheet;
            while (!(numberOfSheet = reader.readLine()).equals("end")) {
                raf.seek(sheet * Integer.parseInt(numberOfSheet));
                for (int i = 0; i < sheet; i++) {
                    System.out.print((char) raf.read());
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
