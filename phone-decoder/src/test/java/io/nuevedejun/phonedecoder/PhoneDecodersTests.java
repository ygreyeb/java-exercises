package io.nuevedejun.phonedecoder;

import io.nuevedejun.phonedecoder.PhoneDecoders.InvalidPhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PhoneDecodersTests {

    @Test
    void testSimpleInput() {
        String in = "800888TeST";
        String result = PhoneDecoders.first().apply(in);
        assertEquals("(800) 888-8378", result);
    }

    @Test
    void testInvalidInput() {
        String in = "80088EST";
        var decoder = PhoneDecoders.first();
        assertThrows(InvalidPhoneNumber.class, () -> decoder.apply(in));
    }

}