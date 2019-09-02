package lambda.live;

import java.util.Arrays;
import java.util.List;

public class Lambda1 {

    public static void main(String[] args) {
        // is it really a Runnable ? @see execute

        // make sort easier

        List<String> letters = Arrays.asList("B", "D", "A", "E", "X", "C");
        letters.sort((o1, o2) -> o1.compareTo(o2));

        System.out.println("letters = " + letters);

        // Retry attempt
        try {
            importantTaskThatMustBeRunSuccessfully();
        } catch (RuntimeException e) {
            System.out.println("e = " + e);
        }
    }

    public static void importantTaskThatMustBeRunSuccessfully() {
        System.out.println("This task really work, if it doesn't everybody will be sad");
    }

    public static void execute(Runnable runnable) {
        runnable.run();
    }

}
