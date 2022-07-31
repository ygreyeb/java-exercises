package io.nuevedejun.phonedecoder;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PhoneDecoders {

    public static final int PHONE_LENGTH = 10;

    private PhoneDecoders() {
        // prevent instantiation
    }

    public static UnaryOperator<String> first() {
        String[] codes = {
                "2", "2", "2", "3", "3", "3",
                "4", "4", "4", "5", "5", "5", "6", "6", "6",
                "7", "7", "7", "7", "8", "8", "8", "9", "9", "9", "9"};
        return in -> {
            String replaced = in.replaceAll("[^\\da-zA-Z]", "");
            String decoded = StreamSupport.stream(chars(replaced).spliterator(), false)
                    .map(ch -> {
                        char unboxed = ch;
                        if (unboxed >= 'a' && unboxed <= 'z') {
                            return codes[unboxed - 'a'];
                        } else if (unboxed >= 'A' && unboxed <= 'Z') {
                            return codes[unboxed - 'A'];
                        }
                        return ch.toString();
                    })
                    .collect(Collectors.joining());
            return format(decoded);
        };
    }

    private static Iterable<Character> chars(final String str) {
        return () -> new Iterator<>() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < str.length();
            }

            @Override
            public Character next() {
                if (!hasNext()) throw new NoSuchElementException();
                return str.charAt(pos++);
            }
        };
    }

    private static String format(String phone) {
        if (phone.length() != PHONE_LENGTH) throw new InvalidPhoneNumber();
        return "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6);
    }

    static class InvalidPhoneNumber extends RuntimeException {
    }
}