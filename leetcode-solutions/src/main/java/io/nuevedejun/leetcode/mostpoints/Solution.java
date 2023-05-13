package io.nuevedejun.leetcode.mostpoints;

public class Solution {
  public long mostPoints(int[][] questions) {
    long[] points = new long[questions.length + 1];
    for (int i = questions.length - 1; i >= 0; i--) {
      int prevIdx = i + questions[i][1] + 1;
      long prev = prevIdx < questions.length ? points[prevIdx] : 0;
      long slide = points[i + 1];
      long potential = questions[i][0] + prev;
      points[i] = potential > slide ? potential : slide;
    }
    return points[0];
  }
}
