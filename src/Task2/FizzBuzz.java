package Task2;

import java.util.LinkedList;
import java.util.Queue;

public class FizzBuzz {
    private volatile int value = 1;

    public final Queue<String> queue = new LinkedList<>();

    public synchronized void number() {
        while (value <= 15) {
            if (value % 3 != 0 && value % 5 != 0) {
                queue.add(String.valueOf(value));
                value++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Error number method!");
                }
            }
        }
    }

    public synchronized void fizz() {
        while (value <= 15) {
            if (value % 3 == 0) {
                queue.add("fizz");
                value++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Error fizz method!");
                }
            }
        }
    }

    public synchronized void buzz() {
        while (value <= 15) {
            if (value % 5 == 0) {
                queue.add("buzz");
                value++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Error buzz method!");
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (value <= 15) {
            if (value % 15 == 0) {
                queue.add("fizzbuzz");
                value++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Error fizzbuzz method!");
                }
            }
        }
    }
}