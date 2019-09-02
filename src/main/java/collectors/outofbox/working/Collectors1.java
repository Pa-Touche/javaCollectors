package collectors.outofbox.working;

import collectors.Movement;
import collectors.outofbox.live.Collectors2;
import collectors.outofbox.live.Collectors4;
import utils.StringUtils;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Collectors1 {
    public static void main(String[] args) {

        // Get math values of a single field
        List<Movement> movements = Collectors2.buildMovementsWithFunctionalDuplicates();

        DoubleSummaryStatistics movementStatistics = movements.stream()
                .filter(mov -> Movement.VALIDATED.equals(mov.getStatus()))
                .collect(Collectors.summarizingDouble(Movement::getValue));

        System.out.println("movementStatistics = " + movementStatistics);

        // Default group by
        List<Movement> movements2 = Collectors4.getMovementsContainingDuplicates();

        // Default groupingBy: toList
        Map<String, List<Movement>> map = movements2.stream()
                // .collect(Collectors.groupingBy(Movement::getStatus, Collectors.toList()));
                .collect(Collectors.groupingBy(Movement::getStatus));
        StringUtils.sysoMap(map);


        // count occurences of movements
        Map<Movement, Long> occurenCount = movements2.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("occurenCount = " + occurenCount);

    }
}
