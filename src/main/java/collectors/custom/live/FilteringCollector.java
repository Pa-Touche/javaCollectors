package collectors.custom.live;

import java.util.function.Predicate;
import java.util.stream.Collector;

/**
 * Java 9 already has a Filtering collector out of the box, but Java 8 doesn't
 */
public class FilteringCollector {

    // A filtering collector takes a downStreamCollector and checks a predicate on each element;
    static <T, A, R> Collector<T, A, R> filtering(Predicate<? super T> filter, Collector<T, A, R> downStreamCollector) {
        return null;
    }
}
