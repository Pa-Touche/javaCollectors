package stream.live;

import stream.MutableTuple;
import stream.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static collectors.outofbox.live.Collectors4.getPersonsWithAddresses;

public class Stream2 {
    public static void main(String[] args) {
        // SORT
        Supplier<Stream<String>> unorderedLetters = () -> Stream.of("c", "d", "a", "b");

        // Infinite stream:

        // Side effects ? peek
        MutableTuple<String, Integer> tuple1 = new MutableTuple<>("tuple1", 1);
        MutableTuple<String, Integer> tuple2 = new MutableTuple<>("tuple2", 2);
        MutableTuple<String, Integer> tuple3 = new MutableTuple<>("tuple3", 3);

        List<MutableTuple<String, Integer>> tuples = Arrays.asList(tuple1, tuple2, tuple3);

        // make string to camel case


        // Get person with biggest number of addresses
        List<Person> personsWithAddresses = getPersonsWithAddresses();

        // Get person with biggest number of addresses
        Optional<Person> personWithBiggestNumberOfAddres = personsWithAddresses.stream()
                .max(Comparator.comparing(per -> per.getAddresses().size()));

        System.out.println(personWithBiggestNumberOfAddres.get());

    }
}
