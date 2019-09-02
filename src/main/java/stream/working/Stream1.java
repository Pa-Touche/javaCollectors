package stream.working;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args) {
        // How to get a stream

        String[] letters = {"A", "b", "C", "D"};
        List<String> strings = Arrays.asList(letters);

        Stream<String> stream1 = strings.stream();

        Stream<String> stream2 = Stream.of(letters);

        stream2.forEach(s -> System.out.println("s = " + s));

        // Lazy execution

        Stream.of("oizadj", "oiajzdojdzai")
                .map(stream.live.Stream1::coolStringEnhancer);
        // .collect(Collectors.toList());

        // Can only be used once

//        List<String> skippedFirstLetter = stream2.skip(1)
//                .collect(Collectors.toList()); // This breaks at runtime
//        System.out.println("skippedFirstLetter = " + skippedFirstLetter);

        Supplier<Stream<String>> streamSupplier = () -> Stream.of(letters);
        String joinedLetters = streamSupplier.get()
                .collect(Collectors.joining("-"));
        System.out.println("joinedLetters = " + joinedLetters);


        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                })
                .collect(Collectors.toList());


    }
}
