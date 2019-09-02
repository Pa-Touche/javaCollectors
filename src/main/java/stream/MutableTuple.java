package stream;

public class MutableTuple<X extends Comparable<X>, Y extends Comparable<Y>> implements Comparable<MutableTuple<X, Y>> {
    public X x;
    public Y y;

    public MutableTuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(MutableTuple<X, Y> compared) {
        return x.compareTo(compared.x);
    }

    @Override
    public String toString() {
        return "MutableTuple{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
