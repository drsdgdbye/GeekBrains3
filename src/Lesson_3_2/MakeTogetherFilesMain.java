package Lesson_3_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class MakeTogetherFilesMain {
    private static ArrayList<InputStream> inputStreamsList;
    private static SequenceInputStream in;
    private static FileOutputStream out;

    static void fillArrayList() {
        inputStreamsList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            try {
                inputStreamsList.add(new FileInputStream(String.format("test\\%d.txt", i)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static void makeTogether() {
        in = new SequenceInputStream(Collections.enumeration(inputStreamsList));
        byte[] br = new byte[100];

        try {
            out = new FileOutputStream("test\\6.txt");
            int x;
            while ((x = in.read(br)) != -1) {
                out.write(br, 0, x);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        fillArrayList();
        makeTogether();
    }
}
