package io.nuevedejun.leetcode.subsequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void numSubseq1() {
    assertEquals(4, solution.numSubseq(new int[]{3, 5, 6, 7}, 9));
  }

  @Test
  void numSubseq2() {
    assertEquals(6, solution.numSubseq(new int[]{3, 3, 6, 8}, 10));
  }

  @Test
  void numSubseq3() {
    assertEquals(61, solution.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
  }

  @Test
  void numSubseq4() {
    assertEquals(272187084, solution.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
  }

  @Test
  void numSubseq5() {
    assertEquals(688052206, solution.numSubseq(new int[]{27, 21, 14, 2, 15, 1, 19, 8, 12, 24, 21, 8, 12, 10, 11, 30, 15, 18, 28, 14, 26, 9, 2, 24, 23, 11, 7, 12, 9, 17, 30, 9, 28, 2, 14, 22, 19, 19, 27, 6, 15, 12, 29, 2, 30, 11, 20, 30, 21, 20, 2, 22, 6, 14, 13, 19, 21, 10, 18, 30, 2, 20, 28, 22}, 31));
  }

  @Test
  void numSubseq6() {
    assertEquals(91931447, solution.numSubseq(new int[]{9, 25, 9, 28, 24, 12, 17, 8, 28, 7, 21, 25, 10, 2, 16, 19, 12, 13, 15, 28, 14, 12, 24, 9, 6, 7, 2, 15, 19, 13, 30, 30, 23, 19, 11, 3, 17, 2, 14, 20, 22, 30, 12, 1, 11, 2, 2, 20, 20, 27, 15, 9, 10, 4, 12, 30, 13, 5, 2, 11, 29, 5, 3, 13, 22, 5, 16, 19, 7, 19, 11, 16, 11, 25, 29, 21, 29, 3, 2, 9, 20, 15, 9}, 32));
  }
}
