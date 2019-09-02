package lambda.live;

import lambda.CsvColumn;
import lambda.FakeParseException;
import lambda.PersonColumn;
import org.apache.commons.csv.CSVRecord;
import stream.Person;

import java.util.ArrayList;
import java.util.List;

public class Lambda2 {
    public static void main(String[] args) {
        Person person = new Person();

        // Parse CSV: apache common-csv. Instead of failing immediately aggregate all exceptions and return them to the user
        CSVRecord record = null;

        // this kind verbose
        List<String> errors = new ArrayList<>();
        try {
            person.setAge(getAgeFromRecord(record, PersonColumn.AGE));
        } catch (FakeParseException e) {
            errors.add(e.getMessage());
        }

        // can this be eased ?

        System.out.println(String.format("Parsing triggered %s errors: %s", errors.size(), errors));
    }

    /**
     * @param record
     * @return
     * @throws FakeParseException
     */
    public static int getAgeFromRecord(CSVRecord record, Enum<? extends CsvColumn> column) {
        if (Math.random() < 0.5) {
            throw new FakeParseException("Not a valid error age", column, record);
        }
        return 0;
    }
}
