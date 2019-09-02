package collectors.custom.working;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Thumbrule: put as little logic in Collectors as possible
 *
 * @param <T>
 * @param <K>
 * @param <V>
 */
public class MapCollector<T, K, V> implements Collector<T, Map<K, V>, Map<K, V>> {

    private final Function<T, K> keyFct;
    private final Function<T, V> valueFct;

    private final boolean removeNullValues;

    public MapCollector(Function<T, K> keyFct, Function<T, V> valueFct) {
        this.keyFct = keyFct;
        this.valueFct = valueFct;
        this.removeNullValues = true;
    }

    public MapCollector(Function<T, K> keyFct, Function<T, V> valueFct, boolean removeNullValues) {
        this.keyFct = keyFct;
        this.valueFct = valueFct;
        this.removeNullValues = removeNullValues;
    }

    @Override
    public Supplier<Map<K, V>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, V>, T> accumulator() {
        return (m, t) -> {
            V value = valueFct.apply(t);

            if (removeNullValues && value == null) {
                return;
            }

            m.put(keyFct.apply(t), value);
        };
    }

    @Override
    public BinaryOperator<Map<K, V>> combiner() {
        return (kvMap, kvMap2) -> {
            kvMap.putAll(kvMap2);

            return kvMap;
        };
    }

    @Override
    public Function<Map<K, V>, Map<K, V>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>(Arrays.asList(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }
}
