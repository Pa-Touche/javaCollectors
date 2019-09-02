package stream;

public class GeographicDistribution {
    public static final String EUROPE = "America";
    public static final String ASIA = "Asia";

    private final Double europe;
    private final Double asia;

    public GeographicDistribution(Double europe, Double asia) {
        this.europe = europe;
        this.asia = asia;
    }

    public Double getEurope() {
        return europe;
    }

    public Double getAsia() {
        return asia;
    }
}
