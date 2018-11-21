package Lesson_1_1;

class Main<T> {
    void swapElements(T[] array) {
        T t = array[0];
        array[0] = array[1];
        array[1] = t;
    }
}
