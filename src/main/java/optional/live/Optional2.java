package optional.live;

import collectors.Person;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Optional2 {

	public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("A", "France", new Date(), 1000.0),
                new Person("B", "France", new Date(), 2000.0),
                new Person("C", "France", new Date(), 3000.0),
                new Person("D", "Scotland", new Date(), 1500.0),
                new Person("E", "England", new Date(), 9999.99)
        );
        
        // Find map of Birth countries with value highest salary, but not scotland
        
	}
}
