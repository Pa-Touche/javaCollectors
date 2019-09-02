package collectors.outofbox.working;

import stream.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static collectors.outofbox.live.Collectors4.getPersonsWithAddresses;

public class Collectors4 {

    public static void main(String[] args) {

        List<Person> personsWithAddresses = getPersonsWithAddresses();

        Map<String, Integer> personWithNumberOfAddresses = personsWithAddresses.stream()
                .collect(Collectors.toMap(Person::getFirstName, per -> per.getAddresses().size()));

        System.out.println(personWithNumberOfAddresses);

        // Find 2 first person with highest number of addresses

        List<Map.Entry<Integer, List<String>>> firstNamesWithHighestNumberOfAddresses =
                personWithNumberOfAddresses.entrySet().stream()
                        .collect(groupByValueAndInvert())
                        .entrySet().stream()
                        .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
                        .limit(2)
                        .collect(Collectors.toList());

        System.out.println("firstNamesWithHighestNumberOfAddresses = " + firstNamesWithHighestNumberOfAddresses);

    }

    public static Collector<Map.Entry<String, Integer>, ?, Map<Integer, List<String>>> groupByValueAndInvert() {
        return Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList()));
    }


}
