package utils;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {
    private StreamUtils() {
    }

    public static <T> Stream<T> streamOf(Iterator<T> iterator) {
        return asStream(iterator, false);
    }

    public static <T> Stream<T> asStream(Iterator<T> iterator, boolean parallel) {
        Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

    public static <K, V> Stream<Map.Entry<K, V>> stream(final Map<K, V> map) {
        return map.entrySet().stream();
    }

    // Useful for Java < 9
    public static <K, V> Stream<Map.Entry<K, V>> flatMapOptional(Stream<Map.Entry<K, Optional<V>>> stream) {
        return stream
                .filter(entry -> entry.getValue().isPresent())
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().get()));
    }

    public static <K, V> Stream<Map.Entry<K, V>> flatMapOptional(Map<K, Optional<V>> map) {
        return stream(map)
                .filter(entry -> entry.getValue().isPresent())
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().get()));
    }

}
