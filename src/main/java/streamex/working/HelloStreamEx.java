package streamex.working;

import one.util.streamex.EntryStream;
import one.util.streamex.StreamEx;

import java.util.List;
import java.util.Map;

import static streamex.live.HelloStreamEx.buildCountriesMap;

/**
 * Streamex makes stream API less verbose
 */
public class HelloStreamEx {
    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,5,6};

        Map<Integer, Integer> entries = EntryStream.of(ints)
                .toMap();

        System.out.println("entries = " + entries);

        List<Integer> integers = StreamEx.of(ints)
                .append(7, 8, 9)
                .toList();
        System.out.println("integers = " + integers);

        Map<String, List<String>> stringMap = buildCountriesMap();

        System.out.println(invert(stringMap));
    }

    private static Map<String, List<String>> invert(Map<String, List<String>> map) {
        return EntryStream.of(map)
                .flatMapValues(List::stream)
                .invert()
                .grouping();
    }

}
