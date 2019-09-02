package collectors.outofbox.live;

import collectors.Movement;

import java.util.List;

import static collectors.outofbox.live.Collectors4.getMovementsContainingDuplicates;

public class Collectors3 {

    public static void main(String[] args) {
        // Movement is a financial operation: users want to see grouped summaries
        List<Movement> movements = getMovementsContainingDuplicates();

        // StringUtils.sysoMap(groupedMovements);
    }


}
