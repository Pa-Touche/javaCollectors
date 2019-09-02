package collectors.outofbox.working;

import collectors.GroupedMovement;
import collectors.Movement;
import utils.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static collectors.outofbox.live.Collectors4.getMovementsContainingDuplicates;

public class Collectors3 {

    public static void main(String[] args) {

        List<Movement> movements = getMovementsContainingDuplicates();


        Map<GroupedMovement, List<Movement>> groupedMovements = movements.stream()
                .collect(Collectors.groupingBy(GroupedMovement::new));

        StringUtils.sysoMap(groupedMovements);
    }


}
