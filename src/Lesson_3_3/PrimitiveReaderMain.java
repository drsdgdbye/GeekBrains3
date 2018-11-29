package Lesson_3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

 class PrimitiveReaderMain {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("test\\1.txt", "r");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int sheet = 1;
            byte br[] = new byte[sheet];
            String s;
            while (true) {
                System.out.println("введите номер страницы");
                if (!(s = reader.readLine()).equals("end")) {
                    raf.seek(sheet * Integer.parseInt(s));

                    int x;
                    while (raf.read() != -1) {
                        System.out.println((char) raf.read());
                    }


                } else break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
