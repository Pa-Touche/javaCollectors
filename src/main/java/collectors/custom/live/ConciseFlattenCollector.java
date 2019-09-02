package collectors.custom.live;

import collectors.custom.working.MapCollector;
import utils.StreamUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public static Map<String, Double> flattenMap(Map<String, Double> mapToFlat) {
        List<String> keys = new ArrayList<>(mapToFlat.keySet());

        int lastItemKey = mapToFlat.size() - 1;
        double sum = mapToFlat.entrySet().stream()
                .limit(lastItemKey)
                .mapToDouble(Map.Entry::getValue)
                .sum();

        mapToFlat.put(keys.get(lastItemKey), 100 - sum);

        return mapToFlat;
    }
}
