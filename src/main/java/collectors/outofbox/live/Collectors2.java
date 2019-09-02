package collectors.outofbox.live;

import collectors.Movement;

import java.util.Arrays;
import java.util.List;

import static collectors.Movement.*;

public class Collectors2 {

    public static void main(String[] args) {
        // collectors can be 'composed' nicely: build this: Map<String, Set<Double>> were K is status
        List<Movement> movements = buildMovementsWithFunctionalDuplicates();
    }

    public static List<Movement> buildMovementsWithFunctionalDuplicates() {
        return Arrays.asList(new Movement(10, PENDING), new Movement(50, PENDING), new Movement(80, PENDING),
                new Movement(30, CANCELLED), new Movement(40, CANCELLED),
                new Movement(200, VALIDATED), new Movement(300, VALIDATED), new Movement(250, VALIDATED), new Movement(35, VALIDATED));
    }
}
