package io.nuevedejun.leetcode.diagonalsum;

public class Solution {
  public int diagonalSum(int[][] mat) {
    int cum = 0;
    int top = mat.length - 1;
    for (int i = 0; i < mat.length; i++) {
      cum += mat[i][i] + mat[i][top - i];
    }
    if ((mat.length & 1) > 0) {
      int half = mat.length >>> 1;
      cum -= mat[half][half];
    }
    return cum;
  }
}
