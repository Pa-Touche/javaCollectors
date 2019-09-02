package collectors.outofbox.working;

import collectors.Movement;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static collectors.outofbox.live.Collectors2.buildMovementsWithFunctionalDuplicates;

public class Collectors2 {

    public static void main(String[] args) {
        // Collector composition

        List<Movement> movements = buildMovementsWithFunctionalDuplicates();

        Map<String, Set<Double>> valuesByStatus = movements.stream()
                .collect(Collectors.groupingBy(Movement::getStatus, Collectors.mapping(Movement::getValue, Collectors.toSet())));

        System.out.println("valuesByStatus = " + valuesByStatus);

    }

}
