package lambda.checked.working;

import lambda.checked.live.CheckedExceptionWrapper;

import java.util.List;
import java.util.stream.Collectors;

import static lambda.checked.live.CheckedExceptionWrapper.getInts;
import static lambda.checked.live.CheckedExceptionWrapper.methodDoesNothingButThrowsException;

/**
 * Thumb-rule: make lambdas as short as possible
 */
public class CheckedWrapper {

    public static void main(String[] args) {
        // Ugly way:
        List<String> uglyWay = getInts().stream()
                .map(n -> {
                    try {
                        return methodDoesNothingButThrowsException(n);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("Should have been handled...");
                    }
                })
                .collect(Collectors.toList());

        // nice compromise
        List<String> convertedStrings = getInts().stream()
                .map(n -> wrapperAroundNothing(n))
                .collect(Collectors.toList());
        System.out.println("convertedStrings = " + convertedStrings);

        // not always fine
        try {
            List<String> anotherWay = getInts().stream()
                    .map(FunctionWithException.wrapper(CheckedExceptionWrapper::methodDoesNothingButThrowsException))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            System.out.println("Sorry the could I wrote failed in front of everyone");
            throw new RuntimeException("Should have been handled...");
        }
    }

    private static String wrapperAroundNothing(Integer n) {
        try {
            return methodDoesNothingButThrowsException(n);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Should have been handled...");
        }
    }
}
