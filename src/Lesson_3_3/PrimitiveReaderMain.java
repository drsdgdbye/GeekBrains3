package Lesson_3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

class PrimitiveReaderMain {
    private static RandomAccessFile raf;

    static void readSheetFromFile(String numberOfSheet) {
        try {
            raf = new RandomAccessFile("test\\1.txt", "r");
            int sheet = 1800;

            raf.seek(sheet * Integer.parseInt(numberOfSheet));
            for (int i = 0; i < sheet; i++) {
                System.out.print((char) raf.read());
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String numberOfSheet;
            while (!(numberOfSheet = reader.readLine()).equals("end")) {
                readSheetFromFile(numberOfSheet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
