package io.nuevedejun.md5hash;

import io.nuevedejun.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Md5HashCalculatorsTests {
    private static final Function<String, byte[]> REF = Md5HashCalculators.reference();

    private static final int COMPARISONS = 1000;
    private static final int MIN_STR_SIZE = 100;
    private static final int MAX_STR_SIZE = 1000;

    @Test
    void testFirst() {
        Function<String, byte[]> calculator = Md5HashCalculators.first();

        for (int i = 0; i < COMPARISONS; i++) {
            String str = Utils.randomString(sizeForIteration(i));
            assertTrue(haveSameBytes(REF.apply(str), calculator.apply(str)));
        }
    }

    private int sizeForIteration(int it) {
        return MIN_STR_SIZE + ((it * (MAX_STR_SIZE - MIN_STR_SIZE)) / COMPARISONS);
    }

    private boolean haveSameBytes(byte[] b0, byte[] b1) {
        boolean eof = false;
        for (int i = 0; i < b0.length && !eof; i++) {
            if (i < b1.length) {
                if (b0[i] != b0[i]) {
                    return false;
                }
            } else {
                eof = true;
            }
        }
        return !eof;
    }

}
