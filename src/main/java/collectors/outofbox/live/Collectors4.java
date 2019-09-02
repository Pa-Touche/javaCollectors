package collectors.outofbox.live;

import collectors.Movement;
import stream.Address;
import stream.Person;

import java.util.Arrays;
import java.util.List;

import static collectors.Movement.*;

public class Collectors4 {

    public static void main(String[] args) {

        List<Person> personsWithAddresses = getPersonsWithAddresses();

        // Get number of addresses for each firstname

        // Find 2 first person with biggest number of addresses

    }

    public static List<Person> getPersonsWithAddresses() {
        Person person1 = Person.of("Charles");
        List<Address> addresses1 = Arrays.asList(new Address(), new Address(), new Address(), new Address());
        person1.setAddresses(addresses1);

        Person person2 = Person.of("Tobias");
        List<Address> addresses2 = Arrays.asList(new Address(), new Address(), new Address());
        person2.setAddresses(addresses2);

        Person person3 = Person.of("Beat");
        List<Address> addresses3 = Arrays.asList(new Address(), new Address(), new Address(), new Address(), new Address());
        person3.setAddresses(addresses3);

        Person person4 = Person.of("Jan");
        person4.setAddresses(addresses2);

        Person person5 = Person.of("Maximilian");
        person5.setAddresses(addresses3);

        return Arrays.asList(person1, person2, person3, person4, person5);
    }

    public static List<Movement> getMovementsContainingDuplicates() {

        double value1 = 10000;
        double value2 = 5000;

        int commitment1 = 100000;
        int commitment2 = 50000;


        Movement val1Pending = new Movement(value1, PENDING);
        Movement val2Cancelled = new Movement(value2, CANCELLED);

        return Arrays.asList(val1Pending, val1Pending,
                new Movement(value1, VALIDATED), val2Cancelled,
                val2Cancelled, val2Cancelled, new Movement(value2, PENDING));
    }
}
