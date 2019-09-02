package utils;

import collectors.Movement;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class StringUtils {
    private StringUtils() {
    }

    public static String generateRandom() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }


    // why can't I write sysoMap(Map<?, List<?>> map) {
    public static void sysoMap(Map<?, List<Movement>> map) {
        map.forEach((key, value) -> System.out.println(String.format("\nKey: %s, count: %s values: %s", key, value.size(), value)));
    }


    public static String toCamelCase(String string) {
        StringBuilder sb = new StringBuilder(string);
        sb.replace(0, 1, string.substring(0, 1).toUpperCase());
        return sb.toString();
    }
}
