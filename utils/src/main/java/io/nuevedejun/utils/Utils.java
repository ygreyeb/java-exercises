package io.nuevedejun.utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Utils {
    private static final Random RAND = new Random();

    private static final int SPACE = 0x20;
    private static final int TILDE = 0x7e;
    private static final int RANGE = 1 + TILDE - SPACE;

    private static final String NULL = "null";

    private Utils() {
        // prevent instantiation
    }

    /**
     * Generate a random string of the requested length. The string will only
     * contain a subset of printable characters from the latin alphabet.
     * 
     * @param length the length of the string
     * @return a random string
     */
    public static String randomString(int length) {
        int[] codePoints = RAND.ints().limit(length)
                .map(c -> SPACE + (Math.abs(c == Integer.MIN_VALUE ? Integer.MAX_VALUE : c) % RANGE)).toArray();
        return new String(codePoints, 0, codePoints.length);
    }

    /**
     * Executes the provided runnable a number of times and measures the accumulated
     * execution time.
     * 
     * @param runnable the process to execute
     * @param times    the amount of times
     * @return the total duration of the executions
     */
    public static Duration measure(Runnable runnable, int times) {
        long elapsed = 0;
        for (int i = 0; i < times; i++) {
            long start = System.nanoTime();
            runnable.run();
            elapsed = elapsed + System.nanoTime() - start;
        }
        return Duration.ofNanos(elapsed);
    }

    /**
     * Takes a map and creates an string representation of it similar to a JSON
     * string.
     * 
     * @param obj the map of object properties
     * @return the JSON-like string representation of the object
     */
    public static CharSequence jsonLike(Map<String, Object> obj) {
        if (obj == null) {
            return NULL;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean comma = false;
        for (var entry : obj.entrySet()) {
            if (comma) {
                sb.append(", ");
            }
            sb.append('\"').append(entry.getKey()).append("\": ");
            if (entry.getValue() instanceof String) {
                sb.append('\"').append(entry.getValue()).append('\"');
            } else {
                sb.append(entry.getValue());
            }
            comma = true;
        }
        sb.append("}");
        return sb;
    }

    /**
     * Joins all the bytes in the stream into a single string.
     * 
     * @param bytes     the byte stream
     * @param delimiter delimiter between each byte
     * @return the string representation
     */
    public static String join(Stream<Byte> bytes, CharSequence delimiter) {
        return bytes.map(Byte::intValue).map(Integer::toBinaryString)
                .map(s -> ("0000000" + s).substring(s.length() - 1))
                .collect(Collectors.joining(delimiter));
    }

    /**
     * Returns a sequential stream of bytes containing the bytes in the array.
     * 
     * @param bytes the byte array
     * @return the stream of bytes
     */
    public static Stream<Byte> streamOf(byte[] bytes) {
        Iterable<Byte> iterable = () -> new Iterator<>() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < bytes.length;
            }

            @Override
            public Byte next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("there are no more bytes in the array");
                }
                return bytes[pos++];
            }
        };
        return StreamSupport.stream(iterable.spliterator(), false);
    }

}
