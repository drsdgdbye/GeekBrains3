package Lesson_1_3;

class Apple implements Fruit {
    private static float DEFAULT_WEIGHT = 1.0f;

    @Override
    public float getDefaultWeight() {
        return DEFAULT_WEIGHT;
    }
}
