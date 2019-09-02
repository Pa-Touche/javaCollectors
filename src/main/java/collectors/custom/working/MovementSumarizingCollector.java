package collectors.custom.working;

import collectors.GroupedMovement;
import collectors.Movement;
import collectors.custom.GroupedMovementSummary;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static collectors.outofbox.live.Collectors4.getMovementsContainingDuplicates;

public class MovementSumarizingCollector {

    public static void main(String[] args) {
        List<Movement> movements = getMovementsContainingDuplicates();

        GroupedMovementSummary summary = movements.stream()
                .collect(toMovementSummary());

        System.out.println("summary = " + summary);
    }

    public static Collector<Movement, ?, Map<GroupedMovement, List<Movement>>> groupedMovementMap() {
        return Collectors.groupingBy(GroupedMovement::new);
    }

    public static Collector<Movement, ?, GroupedMovementSummary> toMovementSummary() {
        return Collectors.collectingAndThen(groupedMovementMap(), MovementSumarizingCollector::buildSummary);
    }

    private static GroupedMovementSummary buildSummary(Map<GroupedMovement, List<Movement>> groupedMovementsMap) {

        List<GroupedMovement> groupedMovements = groupedMovementsMap.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        List<List<Movement>> listOfMovementLists = groupedMovements.stream()
                .map(groupedMovementsMap::get)
                .collect(Collectors.toList());

        DoubleSummaryStatistics valueStatistics = listOfMovementLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.summarizingDouble(Movement::getValue));

        GroupedMovementSummary summary = new GroupedMovementSummary();
        summary.setValueStatistics(valueStatistics);
        summary.setGroupedMovements(groupedMovements);
        summary.setPlainMovements(listOfMovementLists);

        return summary;
    }

}
