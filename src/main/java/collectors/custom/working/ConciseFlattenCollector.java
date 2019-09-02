package collectors.custom.working;

import utils.StreamUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static collectors.custom.live.ConciseFlattenCollector.flattenMap;

public class ConciseFlattenCollector {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        Map<String, Double> flatenedMap = StreamUtils.stream(map)
                .collect(FlatMapCollector());

        System.out.println("flatenedMap = " + flatenedMap);
    }

    private static Collector<Map.Entry<String, Double>, Map<String, Double>, Map<String, Double>> FlatMapCollector() {
        return Collectors.collectingAndThen(
                new MapCollector<Map.Entry<String, Double>, String, Double>(Map.Entry::getKey, Map.Entry::getValue),
                mapToFlat -> flattenMap(mapToFlat)
        );
    }
}
