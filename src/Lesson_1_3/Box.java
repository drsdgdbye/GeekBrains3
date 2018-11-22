package Lesson_1_3;

import java.util.ArrayList;

class Box<T extends Fruit> {

    private ArrayList<T> box;

    void addFruit(T fruit){
        this.box.add(fruit);
    }

    void intersperseFruits(ArrayList<T> anotherBox){
        for (int i = 0; i < box.size(); i++) {
            anotherBox.add(this.box.get(0));
            this.box.remove(0);
        }
    }

    private float getWeight(){
        return box.size()*(box.size() > 0 ? box.get(0).getDefaultWeight() : 0);
    }

    boolean compare(Box<?> anotherBox){
       return this.getWeight() == anotherBox.getWeight();
    }

    public static void main(String[] args) {
        Box<Apple> box = new Box<>();
        box.addFruit(new Apple());
        Box<Apple> box1 = new Box<>();
        box.intersperseFruits(new ArrayList<>());
        box.compare(box1);

    }

}
