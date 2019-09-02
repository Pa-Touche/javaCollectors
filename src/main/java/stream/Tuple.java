package stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Tuple<X, Y> {
    private final X x;
    private final Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public static <X, Y> Tuple of(X x, Y y) {
        return new Tuple<>(x, y);
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public static void main(String[] args) {

        int val = Stream.of(new Tuple<>("Key", 50),
                new Tuple<>("Key2", 80))
                .max(Comparator.comparing(tuple -> tuple.y))
                .orElseThrow(() -> new IllegalArgumentException("Come one tuple should have a value"))
                .y;

        System.out.println("val = " + val);

        // TODO: IDEA: write code for CashFlowPeriod:

    }
}
