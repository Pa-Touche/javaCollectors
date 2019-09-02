package optional.live;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Optional1 {

	public static void main(String[] args) {
		Supplier<Stream<Double>> streamSupplier = () -> Stream.of(0.0, 0.5, 1.1);

        // Imperative style // find max

        Optional<Double> max = streamSupplier.get().
                filter(Objects::nonNull)
                .filter(val -> val >= 0.5)
                .max(Comparator.comparing(Function.identity()));


        // Only do something if present
		
		
		// handle empty case: fail fast
		
		// default value 
		
		// Java 9: ifPresentOrElse
	
		
	}

	private static void displayResult(double result) {
		System.out.println("Result: " + result);
	}
}
