package Lesson_1_3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> arrayList = new ArrayList<>();

    int getWeight(ArrayList<T> amount, int m) {
        return amount.size() * amount.get(0).getM();
    }

    boolean compare(Box<?> another) {
        if (this.getWeight(ArrayList < ? > a,m) == another.getWeight(ArrayList a, m)){
            return true;
        }
    }
}
