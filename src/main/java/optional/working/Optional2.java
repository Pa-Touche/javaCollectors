package optional.working;

import collectors.Person;
import utils.StreamUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Optional2 {


    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("A", "France", new Date(), 1000.0),
                new Person("B", "France", new Date(), 2000.0),
                new Person("C", "France", new Date(), 3000.0),
                new Person("D", "Scotland", new Date(), 1500.0),
                new Person("E", "England", new Date(), 9999.99)
        );

        Map<String, Optional<Person>> personsWithHighestSalaryByLastName = persons.stream()
                .collect(Collectors.groupingBy(Person::getBirthCountry,
                        Collectors.maxBy(Comparator.comparing(Person::getSalary))));

        System.out.println("personsWithHighestSalaryByLastName = " + personsWithHighestSalaryByLastName);

        Map<String, Person> personWithHighestSalaryByCountry = StreamUtils.stream(personsWithHighestSalaryByLastName)
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toMap(Person::getBirthCountry, Function.identity()));

        // Java 8
        Map<String, Person> collect = StreamUtils.flatMapOptional(personsWithHighestSalaryByLastName)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("personWithHighestSalaryByCountry = " + personWithHighestSalaryByCountry);

    }

}