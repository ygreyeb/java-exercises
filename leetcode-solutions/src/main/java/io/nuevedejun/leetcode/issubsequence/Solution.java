package io.nuevedejun.leetcode.issubsequence;

public class Solution {
  public boolean isSubsequence(String s, String t) {
    int slen = s.length();
    if (slen == 0) return true;
    int tlen = t.length();
    if (slen > tlen) return false;

    int j0 = 0;
    int j1 = slen - 1;
    int i0 = 0;
    int i1 = tlen - 1;
    boolean cont = true;
    while (cont) {
      if (s.charAt(j0) == t.charAt(i0)) j0++;
      cont = i0 < i1;
      if (cont && s.charAt(j1) == t.charAt(i1)) j1--;
      if (j0 > j1) return true;
      i0++;
      i1--;
    }
    return false;
  }
}
