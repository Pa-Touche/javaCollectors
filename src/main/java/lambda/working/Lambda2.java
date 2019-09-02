package lambda.working;

import lambda.FakeParseException;
import lambda.PersonColumn;
import org.apache.commons.csv.CSVRecord;
import stream.Person;

import java.util.ArrayList;
import java.util.List;

import static lambda.live.Lambda2.getAgeFromRecord;

public class Lambda2 {

    public static void main(String[] args) {
        Person person = new Person();

        CSVRecord record = null;

        List<String> errors = new ArrayList<>();
        try {
            person.setAge(getAgeFromRecord(record, PersonColumn.AGE));
        } catch (FakeParseException e) {
            errors.add(e.getMessage());
        }

        executeOrAddErrMsg(() -> person.setAge(getAgeFromRecord(record, PersonColumn.AGE)), errors);
    }

    private static void executeOrAddErrMsg(Runnable runnable, List<String> errors) {
        try {
            runnable.run();
        } catch (FakeParseException e) {
            errors.add(e.getMessage());
        }
    }

}
