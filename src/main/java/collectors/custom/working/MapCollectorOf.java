package collectors.custom.working;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This concise MapCollector can handle null values in
 * @param <T>
 * @param <K>
 * @param <V>
 */
public class MapCollectorOf<T, K, V> {
    private Map<K, V> map = new HashMap<>();
    private Function<T, K> keyFct;
    private Function<T, V> valueFct;

    public MapCollectorOf(Function<T, K> keyFct, Function<T, V> valueFct) {
        this.keyFct = keyFct;
        this.valueFct = valueFct;
    }

    private static <T, K, V> Collector<T, MapCollectorOf<T, K, V>, Map<K, V>> mapCollector(Function<T, K> keyFct, Function<T, V> valueFct) {
        return Collector.of(
                () -> new MapCollectorOf<>(keyFct, valueFct),
                MapCollectorOf::accumulator,
                MapCollectorOf::combiner,
                MapCollectorOf::finisher
        );
    }

    private void accumulator(T element) {
        map.put(keyFct.apply(element), valueFct.apply(element));
    }

    private MapCollectorOf<T, K, V> combiner(MapCollectorOf<T, K, V> toCombine) {
        this.map.putAll(toCombine.map);
        return this;
    }

    private Map<K, V> finisher() {
        return map;
    }
}
