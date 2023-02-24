import Task1.AmountOfTime;
import Task2.FizzBuzz;
import Task2.FizzBuzzTest;

import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        AmountOfTime time = new AmountOfTime();
        Thread performanceProgram = new Thread(time::performed);
        Thread message = new Thread(time::theAmountOfTimeThatHasPassed);
        performanceProgram.start();
        message.start();

        try {
            performanceProgram.join();
            message.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        FizzBuzz fizzBuzzes = new FizzBuzz();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        exec.submit(fizzBuzzes::number);
        exec.submit(fizzBuzzes::fizz);
        exec.submit(fizzBuzzes::buzz);
        exec.submit(fizzBuzzes::fizzbuzz);
        exec.shutdown();
        System.out.println( new FizzBuzzTest().print(fizzBuzzes));
    }
}