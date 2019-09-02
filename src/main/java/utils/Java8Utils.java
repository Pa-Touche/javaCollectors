package utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Utils {

    public static String join(String joinChar, final Object... objects) {
        return Arrays.stream(objects)
                .map(Object::toString)
                .collect(Collectors.joining(joinChar));
    }

    public static <T> String join(Function<T, String> mapper, final T... objects) {
        return Arrays.stream(objects)
                .map(mapper::apply)
                .collect(Collectors.joining());
    }


    public static boolean isOneOfTheObjectNull(Object... objects) {
        return Arrays.stream(objects).anyMatch(Objects::isNull);
    }

    public static Optional<Object> anyOfThoseIsNull(Object... objects) {
        return Arrays.stream(objects).filter(Objects::isNull).findAny();
    }

    public static BiFunction<Double, Double, Double> div = (a, b) -> (a != null ? a : 0) / (b != null ? b : 0);

}
