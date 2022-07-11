package io.nuevedejun.reversestring;

import java.util.function.UnaryOperator;

public class StringReversers {

    private StringReversers() {
        // prevent instantiation
    }

    public static UnaryOperator<String> reference() {
        return create("reference", str -> new StringBuilder(str).reverse().toString());
    }

    public static UnaryOperator<String> reverseIterateWithCharAt() {
        return create("reverseIterateWithCharAt", str -> {
            StringBuilder sb = new StringBuilder(str.length());
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            return sb.toString();
        });
    }

    public static UnaryOperator<String> reverseHalfIterateWithCharAt() {
        return create("reverseHalfIterateWithCharAt", str -> {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < (str.length() / 2); i++) {
                int comp = str.length() - 1 - i;
                char prev = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(comp));
                sb.setCharAt(comp, prev);
            }
            return sb.toString();
        });
    }

    private static UnaryOperator<String> create(String name, UnaryOperator<String> impl) {
        return new UnaryOperator<String>() {
            @Override
            public String apply(String str) {
                return impl.apply(str);
            }

            @Override
            public String toString() {
                return "StringReversers::" + name;
            }
        };
    }

}
