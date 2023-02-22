import Task1.AmountOfTime;

public class Main {
    public static void main(String[] args) {
        AmountOfTime time = new AmountOfTime();
        Thread performanceProgram = new Thread(time::performed);
        Thread message = new Thread(time::theAmountOfTimeThatHasPassed);
        performanceProgram.start();
        message.start();
    }
}