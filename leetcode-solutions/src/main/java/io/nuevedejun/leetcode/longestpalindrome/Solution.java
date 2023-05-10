package io.nuevedejun.leetcode.longestpalindrome;

public class Solution {
  public String longestPalindrome(String s) {
    int len = s.length();
    if (len <= 1) return s;

    boolean[][] palindrome = new boolean[len][len];
    for (int i = 0; i < len; i++) palindrome[i][i] = true;
    int longest = 1;
    int start = 0;

    boolean even = false;
    for (int i = 0; i <= len - 2; i++) {
      int j = i + 1;
      if (s.charAt(i) == s.charAt(j)) {
        palindrome[i][j] = true;
        even = true;
        if (longest < 2) {
          longest = 2;
          start = i;
        }
      }
    }

    boolean odd = false;
    for (int l = 3; l <= len; l++) {
      boolean parity = (l & 1) == 0;
      if (parity) even = false;
      else odd = false;

      for (int i = 0; i <= len - l; i++) {
        int j = i + l - 1;
        if (palindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
          palindrome[i][j] = true;
          if (longest < l) {
            longest = l;
            start = i;
          }
          if (parity) even = true;
          else odd = true;
        }
      }
      if (!even && !odd) break;
    }
    return s.substring(start, start + longest);
  }
}
