package streamex.live;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloStreamEx {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5, 6};

        // get pair: index, value as a stream: EntryStream.of()

        // append values to an existing stream


        Map<String, List<String>> stringMap = buildCountriesMap();

        // invert key and values from Map<K, List<V>>. Flatmapping values

        System.out.println("stringMap = " + stringMap);
    }

    public static Map<String, List<String>> buildCountriesMap() {
        Map<String, List<String>> stringMap = new HashMap<>();
        stringMap.put("A", Arrays.asList("France", "Luxemburg"));
        stringMap.put("B", Arrays.asList("France", "Belgium"));
        stringMap.put("C", Arrays.asList("Germany", "England"));
        return stringMap;
    }


}
