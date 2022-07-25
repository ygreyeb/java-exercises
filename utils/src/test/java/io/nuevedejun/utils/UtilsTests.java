package io.nuevedejun.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UtilsTests {
    private static final int MIN_STR_LEN = 56;
    private static final int MAX_STR_LEN = 127;

    private static final int SPACE = 0x20;
    private static final int TILDE = 0x7e;

    private static final int TIMES = 123;

    @Test
    void testRandomString() {
        for (int length = MIN_STR_LEN; length < MAX_STR_LEN; length++) {
            String str = Utils.randomString(length);

            assertEquals(length, str.length());

            for (int i = 0; i < str.length(); i++) {
                int codePoint = str.codePointAt(i);

                assertTrue(codePoint >= SPACE && codePoint <= TILDE);
            }
        }
    }

    @Test
    void testMeasure() {
        Runnable process = mock(Runnable.class);

        Duration duration = Utils.measure(process, TIMES);

        assertNotNull(duration);
        verify(process, times(TIMES)).run();
    }

    @Test
    void testJsonLikeMultiEntry() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("name", "Bruce");
        obj.put("age", 43);
        obj.put("parents", null);

        String str = Utils.jsonLike(obj).toString();

        assertTrue(str.contains("\"name\": \"Bruce\""));
        assertTrue(str.contains("\"age\": 43"));
        assertTrue(str.contains("\"parents\": null"));
        assertEquals(45, str.length());
    }

    @Test
    void testJsonLikeSingleEntry() {
        Map<String, Object> obj = Map.of("name", "Bruce");

        String str = Utils.jsonLike(obj).toString();

        assertEquals("{\"name\": \"Bruce\"}", str);
    }

    @Test
    void testJsonLikeNull() {
        String str = Utils.jsonLike(null).toString();
        assertEquals("null", str);
    }

    @Test
    void testStreamOfBytes() {
        byte[] bytes = { 0b101, 0b100, 0b1 };
        Stream<Byte> stream = Utils.streamOf(bytes);

        assertTrue(haveSameElements(bytes, stream));
    }

    private boolean haveSameElements(byte[] bytes, Stream<Byte> stream) {
        List<Byte> list = stream.toList();
        for (int i = 0; i < bytes.length; i++) {
            if (!list.get(i).equals(bytes[i])) {
                return false;
            }
        }
        return bytes.length == list.size();
    }

    @Test
    void testJoinBytes() {
        Stream<Byte> bytes = Stream.of(0b101, 0b100, 0b1).map(Integer::byteValue);
        String str = Utils.join(bytes, " ");

        assertEquals("00000101 00000100 00000001", str);
    }

}
