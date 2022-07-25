package io.nuevedejun.md5hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.function.Function;

public class Md5HashCalculators {

    private Md5HashCalculators() {
        // prevent instantiation
    }

    public static Function<String, byte[]> reference() {
        return create("reference", str -> {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(str.getBytes());
                return md.digest();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e); // NOSONAR
            }
        });
    }

    public static Function<String, byte[]> first() {
        // shifts per round
        final int[] shifts = {
                7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22,
                5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20,
                4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23,
                6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21 };

        // constants
        final int[] ks = {
                0xd76aa478, 0xe8c7b756, 0x242070db, 0xc1bdceee,
                0xf57c0faf, 0x4787c62a, 0xa8304613, 0xfd469501,
                0x698098d8, 0x8b44f7af, 0xffff5bb1, 0x895cd7be,
                0x6b901122, 0xfd987193, 0xa679438e, 0x49b40821,
                0xf61e2562, 0xc040b340, 0x265e5a51, 0xe9b6c7aa,
                0xd62f105d, 0x02441453, 0xd8a1e681, 0xe7d3fbc8,
                0x21e1cde6, 0xc33707d6, 0xf4d50d87, 0x455a14ed,
                0xa9e3e905, 0xfcefa3f8, 0x676f02d9, 0x8d2a4c8a,
                0xfffa3942, 0x8771f681, 0x6d9d6122, 0xfde5380c,
                0xa4beea44, 0x4bdecfa9, 0xf6bb4b60, 0xbebfbc70,
                0x289b7ec6, 0xeaa127fa, 0xd4ef3085, 0x04881d05,
                0xd9d4d039, 0xe6db99e5, 0x1fa27cf8, 0xc4ac5665,
                0xf4292244, 0x432aff97, 0xab9423a7, 0xfc93a039,
                0x655b59c3, 0x8f0ccc92, 0xffeff47d, 0x85845dd1,
                0x6fa87e4f, 0xfe2ce6e0, 0xa3014314, 0x4e0811a1,
                0xf7537e82, 0xbd3af235, 0x2ad7d2bb, 0xeb86d391 };

        return create("first", str -> {
            byte[] strBytes = str.getBytes();
            int len = calculateLen(strBytes.length);

            int[] blocks = new int[len];
            Arrays.fill(blocks, 0);
            copyBytes(strBytes, blocks);
            addPadding(strBytes, blocks);

            // initial values
            int a0 = 0x67452301; // A
            int b0 = 0xefcdab89; // B
            int c0 = 0x98badcfe; // C
            int d0 = 0x10325476; // D

            for (int o = 0; o < blocks.length; o += 16) {
                int a = a0;
                int b = b0;
                int c = c0;
                int d = d0;

                for (int i = 0; i < 64; i++) {
                    int f;
                    int g;
                    if (i < 16) {
                        f = d ^ (b & (c ^ d));
                        g = i;
                    } else if (i < 32) {
                        f = c ^ (d & (b ^ c));
                        g = (5 * i + 1) % 16;
                    } else if (i < 48) {
                        f = b ^ c ^ d;
                        g = (3 * i + 5) % 16;
                    } else {
                        f = c ^ (b | (~d));
                        g = (7 * i) % 16;
                    }
                    f = f + a + ks[i] + blocks[o + g];
                    a = d;
                    d = c;
                    c = b;
                    b = b + rotateLeft(f, shifts[i]);
                }

                a0 = a0 + a;
                b0 = b0 + b;
                c0 = c0 + c;
                d0 = d0 + d;
            }

            byte[] result = new byte[16];
            copyBits(new int[] { a0, b0, c0, d0 }, result);
            return result;
        });
    }

    /**
     * Calculates the required length for the <strong>integer</strong> array that
     * will hold the original bytes plus the end padding.
     * 
     * @param length the length of the <strong>byte</strong> array of the input
     *               string
     * @return length of the integer array
     */
    private static int calculateLen(int length) {
        int requiredBytes = length + 9;
        int requiredInts = (requiredBytes >> 2) + ((requiredBytes & 0b11) > 0 ? 1 : 0);
        return ((requiredInts >> 4) + ((requiredInts & 0b1111) > 0 ? 1 : 0)) << 4;
    }

    private static void copyBytes(byte[] source, int[] target) {
        boolean eof = false;
        for (int i = 0; i < source.length && !eof; i += 4) {
            int j = i >> 2;
            if (j < target.length) {
                byte b1 = source[i];
                byte b2 = i + 1 < source.length ? source[i + 1] : 0;
                byte b3 = i + 2 < source.length ? source[i + 2] : 0;
                byte b4 = i + 3 < source.length ? source[i + 3] : 0;
                target[j] = ((0xFF & b1) << 24) | ((0xFF & b2) << 16) | ((0xFF & b3) << 8) | (0xFF & b4);
            } else {
                eof = true;
            }
        }
    }

    private static void copyBits(int[] source, byte[] target) {
        boolean eof = false;
        for (int i = 0; (i + 3) < target.length && !eof; i += 4) {
            int j = i >> 2;
            if (j < source.length) {
                target[i] = (byte) (source[j] >> 24);
                target[i + 1] = (byte) (source[j] >> 16);
                target[i + 2] = (byte) (source[j] >> 8);
                target[i + 3] = (byte) source[j];
            } else {
                eof = true;
            }
        }
    }

    private static void addPadding(byte[] bytes, int[] ints) {
        int bytePos = bytes.length;
        int bit = 0x80000000;
        switch (0b11 & bytePos) {
            case 1:
                bit = 0x00800000;
                break;
            case 2:
                bit = 0x00008000;
                break;
            case 3:
                bit = 0x00000080;
                break;
            default:
                break;
        }
        ints[bytePos >> 2] |= bit;
        ints[ints.length - 1] = bytes.length << 3;
    }

    private static int rotateLeft(int n, int bits) {
        int complement = 32 - bits;
        int mask = ~(0x80000000 >> (complement - 1));
        return (n << bits) | (mask & (n >> complement));
    }

    private static Function<String, byte[]> create(String name, Function<String, byte[]> impl) {
        return new Function<String, byte[]>() {
            @Override
            public byte[] apply(String str) {
                return impl.apply(str);
            }

            @Override
            public String toString() {
                return "Md5HashCalculators::" + name;
            }
        };
    }

}
