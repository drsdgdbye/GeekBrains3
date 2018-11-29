package Lesson_3_1;

import java.io.FileInputStream;
import java.io.IOException;

class ReadFileInByteArrayMain {

    static void outBytesOn(String filename) {
        byte br[] = new byte[50];
        try (FileInputStream in = new FileInputStream(filename)) {
            int x;
            while ((x = in.read(br)) != -1) {
                System.out.println(new String(br, 0, x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String...args) {
        outBytesOn("test\\1.txt");
    }
}
