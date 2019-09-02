package stream.working;

import stream.MutableTuple;
import utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Stream2 {
    public static void main(String[] args) {
        // SORT
        Supplier<Stream<String>> unorderedLetters = () -> Stream.of("c", "d", "a", "b");

        unorderedLetters.get()
                .filter(letter -> "a".equals(letter))
                .sorted(Collections.reverseOrder())
                .forEach(n -> System.out.println("n = " + n));

        // Infinite stream: Stream.iterate()
        Stream<Integer> infiniteStreamEvenInts = Stream.iterate(0, i -> i + 2);

        infiniteStreamEvenInts
                .limit(9)
                .forEach(System.out::println);

        // Side effects ? peek // Streams are based on trust
        MutableTuple<String, Integer> tuple1 = new MutableTuple<>("tuple1", 1);
        MutableTuple<String, Integer> tuple2 = new MutableTuple<>("tuple2", 2);
        MutableTuple<String, Integer> tuple3 = new MutableTuple<>("tuple3", 3);

        List<MutableTuple<String, Integer>> tuples = Arrays.asList(tuple1, tuple2, tuple3);

        Predicate<MutableTuple<String, Integer>> uneven = val -> val.y % 2 != 0;
        tuples.stream()
                .peek(tuple -> tuple.x = StringUtils.toCamelCase(tuple.x))
                .filter(uneven)
                .sorted(Collections.reverseOrder())
                .forEach(val -> System.out.println("val = " + val));

        tuples.stream()
                .filter(uneven)
                .findAny()
                .ifPresent(val -> System.out.println("val = " + val));
    }
}
