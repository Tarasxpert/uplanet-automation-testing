package utils;

import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrsqtuvwxyz";
    private static final String NUMBER = "1234567890";

    private DataGenerator() {}

    public static String generateString(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARS.charAt(randomInteger(CHARS.length())));
        }
        return stringBuilder.toString();
    }

    public static int randomInteger(int fromInclusive, int toExclusive) {
        return ThreadLocalRandom.current().nextInt(fromInclusive, toExclusive);
    }

    public static int randomInteger() {
        return ThreadLocalRandom.current().nextInt();
    }

    public static int randomInteger(int toExclusive) {
        return randomInteger(0, toExclusive);
    }
}
