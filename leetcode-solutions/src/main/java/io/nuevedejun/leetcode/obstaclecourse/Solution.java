package io.nuevedejun.leetcode.obstaclecourse;

public class Solution {
  public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
    if (obstacles.length == 0) return new int[0];

    final int[] result = new int[obstacles.length];
    final int[] pivot = new int[obstacles.length];
    int limit = 0;

    for (int i = 0; i < obstacles.length; i++) {
      int obstacle = obstacles[i];

      int low = 0;
      int high = limit;

      while (low < high) {
        int mid = (low + high) >>> 1;
        if (pivot[mid] <= obstacle)
          low = mid + 1;
        else {
          high = mid;
        }
      }

      pivot[low] = obstacle;
      result[i] = low + 1;
      if (low == limit) limit++;
    }
    return result;
  }
}
