package io.nuevedejun.leetcode.pivotindex;

public class Solution {
  public int pivotIndex(int[] nums) {
    int total = 0;
    for (int num : nums) total += num;
    int lacc = 0;
    for (int i = 0; i < nums.length; i++) {
      if (2 * lacc == total - nums[i]) return i;
      lacc += nums[i];
    }
    return -1;
  }
}
