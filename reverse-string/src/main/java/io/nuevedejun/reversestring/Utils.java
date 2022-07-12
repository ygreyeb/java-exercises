package io.nuevedejun.reversestring;

import java.util.Random;

public class Utils {
    private static final Random RAND = new Random();

    private static final int SPACE = 0x20;
    private static final int TILDE = 0x7e;
    private static final int RANGE = 1 + TILDE - SPACE;

    private Utils() {
        // prevent instantiation
    }

    public static String randomString(int size) {
        int[] codePoints = RAND.ints().limit(size)
                .map(c -> SPACE + (Math.abs(c == Integer.MIN_VALUE ? Integer.MAX_VALUE : c) % RANGE)).toArray();
        return new String(codePoints, 0, codePoints.length);
    }
}
