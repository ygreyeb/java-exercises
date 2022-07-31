package io.nuevedejun.phonedecoder;

import io.nuevedejun.phonedecoder.PhoneDecoders.InvalidPhoneNumber;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;

public class PhoneDecoderApplication {
    private static final Logger LOGGER = System.getLogger(PhoneDecoderApplication.class.getPackageName());

    public static void main(String[] args) {
        new PhoneDecoderApplication().start(List.of(args));
    }

    private void start(List<String> args) {
        var decoder = PhoneDecoders.first();
        for (String arg : args) {
            try {
                String result = decoder.apply(arg);
                LOGGER.log(Level.INFO, "Decoded phone number is " + result + " (original \"" + arg + "\")");
            } catch (InvalidPhoneNumber e) {
                LOGGER.log(Level.INFO, "Provided number is invalid: \"" + arg + "\"");
            }
        }
    }

}