package lambda.working;

import java.util.Arrays;
import java.util.List;

import static lambda.live.Lambda1.execute;
import static lambda.live.Lambda1.importantTaskThatMustBeRunSuccessfully;

public class Lambda1 {
    public static void main(String[] args) {
        // is it really a Runnable ?
        //Executor executeFct = () -> System.out.println("ODodziajoizdjaoidz");
        Runnable executeFct = () -> System.out.println("ODodziajoizdjaoidz");
        execute(executeFct);

        // make sort easier

        List<String> letters = Arrays.asList("B", "D", "A", "E", "X", "C");
        letters.sort((o1, o2) -> o1.compareTo(o2));

        System.out.println("letters = " + letters);

        // Retry attempt
        try {
            importantTaskThatMustBeRunSuccessfully();
        } catch (RuntimeException e) {
            System.out.println("Warn didn't work on first attempt");
            retryAfterDelay(() -> importantTaskThatMustBeRunSuccessfully(), 500);
        }
    }

    public static void retryAfterDelay(Runnable runnable, long delayMs) {
        try {
            Thread.sleep(delayMs);
            runnable.run();
        } catch (RuntimeException e) {
            System.out.println("Even after retry didn't work");
        } catch (InterruptedException e) {
            System.out.println("e = " + e);
        }
    }
}
