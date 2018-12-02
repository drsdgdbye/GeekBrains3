package Lesson_4;

public class Main {
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(() -> main.printA()).start();
        new Thread(() -> main.printB()).start();
        new Thread(() -> main.printC()).start();
    }

    void printA() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void printB() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void printC() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


