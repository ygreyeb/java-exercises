package io.nuevedejun.leetcode.romaninteger;

public class Solution {
  public int romanToInt(String s) {
    int dec = 0;
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      int inc = switch (c) {
        case 'I' -> {
          Info info = preceding(s, i, Roman.I, Roman.V, Roman.X);
          i += info.chars;
          yield info.value;
        }
        case 'X' -> {
          Info info = preceding(s, i, Roman.X, Roman.L, Roman.C);
          i += info.chars;
          yield info.value;
        }
        case 'C' -> {
          Info info = preceding(s, i, Roman.C, Roman.D, Roman.M);
          i += info.chars;
          yield info.value;
        }
        case 'V' -> Roman.V.decimal;
        case 'L' -> Roman.L.decimal;
        case 'D' -> Roman.D.decimal;
        case 'M' -> Roman.M.decimal;
        default -> throw new IllegalStateException("Unexpected value: " + c);
      };
      dec += inc;
      i++;
    }
    return dec;
  }

  private Info preceding(final String str, final int pos, final Roman base, final Roman... follows) {
    int next = pos + 1;
    if (next < str.length()) {
      char nc = str.charAt(next);
      for (Roman follow : follows) {
        if (nc == follow.letter) return new Info(follow.decimal - base.decimal, 1);
      }
    }
    return new Info(base.decimal, 0);
  }

  enum Roman {
    I('I', 1),
    V('V', 5),
    X('X', 10),
    L('L', 50),
    C('C', 100),
    D('D', 500),
    M('M', 1000);

    private final int letter;
    private final int decimal;

    Roman(char letter, int decimal) {
      this.letter = letter;
      this.decimal = decimal;
    }
  }

  private record Info(int value, int chars) {
  }
}
