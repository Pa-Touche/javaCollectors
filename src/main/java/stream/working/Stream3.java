package stream.working;

import stream.GeographicDistribution;
import stream.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println("sorry for that: distributions = " + distributions);

        // Isn't this preferable ?
        String streamDistributions = Stream.of(
                new Tuple<>(EUROPE, geographicDistribution.getEurope()),
                new Tuple<>(ASIA, geographicDistribution.getAsia())
        )
                .filter(tuple -> tuple.getY() != null)
                .map(Tuple::getX)
                .collect(Collectors.joining(";"));
        System.out.println("streamDistributions = " + streamDistributions);


    }
}
