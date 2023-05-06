package io.nuevedejun.leetcode.subsequences;

import java.util.Arrays;

public class Solution {
  private static final int MODULUS = 1000000007;

  public int numSubseq(int[] nums, int target) {
    Arrays.sort(nums);

    var pow = new int[nums.length];
    pow[0] = 1;
    for (var i = 1; i < nums.length; i++) {
      pow[i] = (pow[i - 1] << 1) % MODULUS;
    }

    int half = target / 2;

    int count = 0;
    int i = 0;
    int j = nums.length - 1;
    while (i < nums.length) {
      int v = nums[i];
      if (v > half) break;

      while (j >= i) {
        if (v + nums[j] <= target) break;
        j--;
      }
      count = (count + pow[j - i]) % MODULUS;
      i++;
    }

    return count;
  }
}
