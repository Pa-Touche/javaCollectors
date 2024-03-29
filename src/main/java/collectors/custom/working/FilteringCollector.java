package collectors.custom.working;

import java.util.function.Predicate;
import java.util.stream.Collector;

// TODO: usage of this
public class FilteringCollector {

    public static <T, A, R> Collector<T, A, R> filtering(Predicate<? super T> filter, Collector<T, A, R> collector) {
        return Collector.of(
                collector.supplier(),
                (accumulator, input) -> {
                    if (filter.test(input)) {
                        collector.accumulator().accept(accumulator, input);
                    }
                },
                collector.combiner(),
                collector.finisher());
    }
}
