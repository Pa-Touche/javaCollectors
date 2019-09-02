package lambda.checked.live;

import java.util.Arrays;
import java.util.List;

public class CheckedExceptionWrapper {

	public static void main(String[] args) {
        List<Integer> ints = getInts();

        // this doesn't compile...
//		List<String> intsAsStrings = ints.stream()
//				.map(i -> methodDoesNothingButThrowsException(i))
//				.collect(Collectors.toList());

		// Don't do this:

		// Already better

		// best solution but doesn't apply everywhere

	}

    public static List<Integer> getInts() {
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    public static String methodDoesNothingButThrowsException(int n) throws Exception {
        return String.valueOf(n);
	}
}
