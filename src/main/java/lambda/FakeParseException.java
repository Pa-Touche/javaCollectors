package lambda;

import org.apache.commons.csv.CSVRecord;

public class FakeParseException extends RuntimeException {
    private final Enum<? extends CsvColumn> column;
    private final long rowNumber;

    public FakeParseException(String message, Enum<? extends CsvColumn> column, CSVRecord record) {
        super(message);
        this.column = column;
        this.rowNumber = record == null ? 0 : record.getRecordNumber();
    }

    public Enum<? extends CsvColumn> getColumn() {
        return column;
    }

    public long getRowNumber() {
        return rowNumber;
    }
}
