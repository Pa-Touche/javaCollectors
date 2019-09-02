package stream.live;

import stream.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream4 {

    public static void main(String[] args) {
        // Basic collectors

        // Make a phrase saying 'In germany %%value%% and %%value%% (bis) are of legal age

        Supplier<Stream<Person>> personSupplier = () -> Stream.of(Person.of("d", 43),
                Person.of("b", 20),
                Person.of("a", 5),
                Person.of("c", 20));
        String phrase = personSupplier.get()
                .filter(p -> p.getAge() >= 18)
                .map(Person::getFirstName)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);

        // Parallell Stream // SplitIterator
        boolean noneMatchFive = Arrays.asList(1, 2, 3, 4, 6, 7, 8)
                .parallelStream()
                .noneMatch(i -> i == 5);
        System.out.println("noneMatchFive = " + noneMatchFive);

        // Concat streams

        Person charles1 = Person.of("Charles", 8);
        Person charles2 = new Person(charles1);
        List<Person> persons1 = Arrays.asList(Person.of("Thomas", 5), charles1);

        List<Person> persons2 = Arrays.asList(Person.of("Lucas", 12), charles2, Person.of("Louis", 25));

        String[] concatenatedPersons = Stream.concat(persons1.stream(), persons2.stream())
                .distinct()
                .map(Object::toString)
                .toArray(size -> new String[size]);
        System.out.println("concatenatedPersons = " + Arrays.toString(concatenatedPersons));


    }


    public static Supplier<Stream<Person>> getStreamSupplier() {
        return () -> Stream.of(Person.of("d", 43),
                Person.of("b", 20),
                Person.of("a", 5),
                Person.of("c", 20));
    }
}
