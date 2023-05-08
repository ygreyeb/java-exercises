package io.nuevedejun.leetcode.isisomorphic;

public class Solution {
  public boolean isIsomorphic(String s, String t) {
    char[] back = new char[256];
    char[] forth = new char[256];
    for (int i = 0; i < s.length(); i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);

      char bc = back[sc];
      char fc = forth[tc];
      if (bc != 0 || fc != 0) {
        if (bc != tc || fc != sc) return false;
      } else {
        back[sc] = tc;
        forth[tc] = sc;
      }
    }
    return true;
  }
}
