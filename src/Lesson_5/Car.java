package Lesson_5;

import java.util.concurrent.atomic.AtomicInteger;

import static Lesson_5.MainClass.FINISH;
import static Lesson_5.MainClass.START;

public class Car implements Runnable {

    private static AtomicInteger CARS_COUNT = new AtomicInteger();

    static {
        CARS_COUNT.set(0);
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT.incrementAndGet();
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            START.countDown();
            START.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (CARS_COUNT.get() == MainClass.CARS_COUNT) {
            System.out.println(getName() + " WIN");
            CARS_COUNT.decrementAndGet();
        }
        FINISH.countDown();
    }
}
