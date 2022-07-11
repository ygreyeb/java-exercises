package io.nuevedejun.reversestring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class StringReversersTests {

    private static final UnaryOperator<String> REF = StringReversers.reference();
    private static final Random RAND = new Random();

    private static final int COMPARISONS = 1000;
    private static final int MIN_STR_SIZE = 100;
    private static final int MAX_STR_SIZE = 1000;

    static Stream<UnaryOperator<String>> reversers() {
        return Stream.of(
                StringReversers.reverseIterateWithCharAt(),
                StringReversers.reverseHalfIterateWithCharAt());
    }

    @ParameterizedTest
    @MethodSource("reversers")
    void testReverse(UnaryOperator<String> reverser) {
        for (int i = 0; i < COMPARISONS; i++) {
            String str = randomString(sizeForIteration(i));
            assertEquals(REF.apply(str), reverser.apply(str));
        }
    }

    private int sizeForIteration(int it) {
        return MIN_STR_SIZE + ((it * (MAX_STR_SIZE - MIN_STR_SIZE)) / COMPARISONS);
    }

    private String randomString(int size) {
        byte[] bytes = new byte[size];
        RAND.nextBytes(bytes);
        return new String(bytes);
    }

}
