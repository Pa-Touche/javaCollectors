package collectors.custom.working;

import collectors.custom.live.ConciseFlattenCollector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class FlattenCollector implements Collector<Map.Entry<String, Double>, FlattenCollector, Map<String, Double>> {

    private final Map<String, Double> acc = new HashMap<>();

    @Override
    public Supplier<FlattenCollector> supplier() {
        return FlattenCollector::new;
    }

    @Override
    public BiConsumer<FlattenCollector, Map.Entry<String, Double>> accumulator() {
        return (flattenCollector, entry) -> {
            Double value = entry.getValue();
            if (value == null || value == 0.0) {
                return;
            }

            acc.put(entry.getKey(), value);
        };
    }

    @Override
    public BinaryOperator<FlattenCollector> combiner() {
        return (flattenCollector, flattenCollector2) -> {
            flattenCollector.acc.putAll(flattenCollector2.acc);
            return flattenCollector;
        };
    }

    @Override
    public Function<FlattenCollector, Map<String, Double>> finisher() {
        return flattenCollector -> ConciseFlattenCollector.flattenMap(flattenCollector.acc);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}
