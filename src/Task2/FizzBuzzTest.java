package Task2;

import java.util.StringJoiner;

public class FizzBuzzTest {
    public  String print(FizzBuzz fizzBuzzes) {
        StringJoiner joiner = new StringJoiner(", ");
        while (!fizzBuzzes.queue.isEmpty())
            joiner.add(fizzBuzzes.queue.poll());

        return joiner.toString();
    }
}
