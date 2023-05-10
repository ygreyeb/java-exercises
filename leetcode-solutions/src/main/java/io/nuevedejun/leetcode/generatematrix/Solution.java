package io.nuevedejun.leetcode.generatematrix;

public class Solution {
  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];

    int top = 0;
    int right = n - 1;
    int bottom = n - 1;
    int left = 0;
    int i = 1;
    while (i <= n * n) {
      for (int j = left; j <= right; j++) {
        result[top][j] = i++;
      }
      top++;

      for (int j = top; j <= bottom; j++) {
        result[j][right] = i++;
      }
      right--;

      for (int j = right; j >= left; j--) {
        result[bottom][j] = i++;
      }
      bottom--;

      for (int j = bottom; j >= top; j--) {
        result[j][left] = i++;
      }
      left++;
    }

    return result;
  }
}
