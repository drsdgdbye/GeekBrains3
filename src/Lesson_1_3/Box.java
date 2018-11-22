package Lesson_1_3;

import java.util.ArrayList;

class Box<T extends Fruit> {
    private ArrayList<T> box;
    private float weight;

    void addFruit(ArrayList<T> box, T fruit){
        box.add(fruit);
    }

    void intersperseFruits(ArrayList<T> box, ArrayList<T> anotherBox){
        for (int i = 0; i < box.size(); i++) {
            anotherBox.add(box.get(0));
            box.remove(0);
        }
    }

    private float getWeight(){
        return box.size()*(box.size() > 0 ? box.get(0).getDefaultWeight() : 0);
    }

    boolean compare(Box<?> anotherBox){
       return this.getWeight() == anotherBox.getWeight();
    }


}
