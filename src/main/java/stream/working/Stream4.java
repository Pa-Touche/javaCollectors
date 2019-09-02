package stream.working;

import stream.Person;

import java.util.Arrays;
import java.util.List;

public class Stream4 {

    public static void main(String[] args) {
        // Basic collectors

        // Make a phrase saying 'In germany %%value%% and %%value%% (bis) are of legal age for age > 18

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


    }

}
