package Task2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzz {
    private volatile int value = 1;

    private final Queue<String> queue = new LinkedList<>();

    public synchronized String print() {
        StringJoiner joiner = new StringJoiner(", ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Error while reading queue");
        }
        while (!queue.isEmpty())
            joiner.add(queue.poll());

        return joiner.toString();
    }

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

    public static void main(String[] args) {
        FizzBuzz fizzBuzzes = new FizzBuzz();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        exec.submit(fizzBuzzes::number);
        exec.submit(fizzBuzzes::fizz);
        exec.submit(fizzBuzzes::buzz);
        exec.submit(fizzBuzzes::fizzbuzz);
        exec.submit(fizzBuzzes::print);
    }
}