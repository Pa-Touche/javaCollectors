package collectors.outofbox.live;

import collectors.Movement;

import java.util.List;

public class Collectors1 {
    public static void main(String[] args) {

        // Get math values of a single field for validated movements
        List<Movement> movements = Collectors2.buildMovementsWithFunctionalDuplicates();


        // Default group by
        List<Movement> movements2 = Collectors4.getMovementsContainingDuplicates();


        // count occurences of movements

    }
}
