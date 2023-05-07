package io.nuevedejun.leetcode.twosum;

import java.util.HashMap;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    final var map = new HashMap<Integer, Integer>(nums.length, 1);
    for (int i = 0; i < nums.length; i++) {
      final int value = nums[i];
      final int required = target - value;
      final Integer j = map.get(required);
      if (j != null) return new int[]{i, j};
      map.put(value, i);
    }
    return new int[]{};
  }
}
