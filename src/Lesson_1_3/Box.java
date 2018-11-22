package Lesson_1_3;

import java.util.ArrayList;

class Box<T extends Fruit> {
    private ArrayList<T> box;
    private float weight;

    Box(ArrayList<T> box, float weight){
        this.box = box;
        this.weight = weight;
    }

    void addFruit(ArrayList<T> box, T fruit){
        box.add(fruit);
    }

    void intersperseFruits(ArrayList<T> box, ArrayList<T> anotherBox){
        for (int i = 0; i < box.size(); i++) {
            anotherBox.add(box.get(0));
            box.remove(0);
        }
    }

    float getWeight(){
        return box.size()*weight;
    }

    boolean compare(Box<?> anotherBox){
        return Math.abs(this.getWeight() - anotherBox.getWeight()) == 0;
    }


}
