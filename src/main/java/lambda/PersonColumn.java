package lambda;

public enum PersonColumn implements CsvColumn {
    AGE("Age");

    public final String label;

    PersonColumn(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
