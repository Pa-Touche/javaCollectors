package stream.live;

import stream.GeographicDistribution;

import java.util.ArrayList;
import java.util.List;

import static stream.GeographicDistribution.ASIA;
import static stream.GeographicDistribution.EUROPE;

public class Stream3 {

    public static void main(String[] args) {
        // please don't write code like this

        GeographicDistribution geographicDistribution = new GeographicDistribution(50.0, null);
        List<String> distributions = new ArrayList<>();

        Double europaDistribution = geographicDistribution.getEurope();
        if (europaDistribution != null) {
            distributions.add(EUROPE);
        }

        Double asiaDistribution = geographicDistribution.getAsia();
        if (asiaDistribution == null) {
            distributions.add(ASIA);
        }
        System.out.println("sorry for that: distributions = " + String.join(";", distributions));

        // Isn't using tuples nicer?


    }
}
