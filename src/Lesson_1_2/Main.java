package Lesson_1_2;

import java.util.ArrayList;
import java.util.Arrays;

class Main<E> {
    ArrayList<E> changeToArrayList(E[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
