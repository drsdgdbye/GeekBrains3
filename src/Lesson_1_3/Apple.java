package Lesson_1_3;

class Apple implements Fruit {
    private static float weight;
    private static float DEFAULT_WEIGHT = 1.0f;

    Apple(){}

    Apple(float weight){
        this.weight = weight;
    }

    @Override
    public float getDefaultWeight() {
        return DEFAULT_WEIGHT;
    }
}
