package optional.working;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Optional1 {
	public static void main(String[] args) {
		Supplier<Stream<Double>> streamSupplier = () -> Stream.of(0.0, 0.5, 1.1);
		
		// Imperative style 
		
		Optional<Double> max = streamSupplier.get().
			max(Comparator.comparing(Function.identity()));
		
		if (max.isPresent()) {
			displayResult(max.get());
		} else {
			throw new RuntimeException("No result!");
		}
		
		// Only do something if present 
		
		streamSupplier.get()
		.filter(Objects::nonNull)
		.findAny()
		.ifPresent(result -> displayResult(result));
		
		Supplier<Stream<Double>> emptyStream = () -> Stream.empty();
		
		// handle empty case
		double value = emptyStream.get()
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Nothing here !!"));
		
		System.out.println("Default value");
		
		// default value 
		double defaultValue = emptyStream.get()
				.findAny()
				.orElse(0.0); // orElseGet(() -> 0.0)
		System.out.println("Default value");
		
		// Java 9
		emptyStream.get()
		.findAny()
		.ifPresentOrElse(result -> displayResult(result), () -> new RuntimeException("Nothing here !!"));
		
	}

	private static void displayResult(double result) {
		System.out.println("Result: " + result);
	}
}
