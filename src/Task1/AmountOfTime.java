package Task1;

public class AmountOfTime {
    private static int second = 0;

    public void performed() {
        while (second < 20) {
            for (int i = 0; i < 5; i++) {
                second++;
                System.out.printf("The program is performed %d seconds\n", second);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Error!");
            }
            theAmountOfTimeThatHasPassed();
        }
    }

    public void theAmountOfTimeThatHasPassed() {
        if (second != 1)
            System.out.printf("%d seconds have passed!\n", second);
    }
}
