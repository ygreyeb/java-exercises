package io.nuevedejun.leetcode.mergetwolists;

import org.junit.jupiter.api.Test;

import static io.nuevedejun.leetcode.utils.TestUtils.ln;
import static io.nuevedejun.leetcode.utils.TestUtils.same;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void mergeTwoLists0() {
    assertTrue(same(ln(1, 1, 2, 3, 4, 4), solution.mergeTwoLists(ln(1, 2, 4), ln(1, 3, 4))));
  }

  @Test
  void mergeTwoLists1() {
    assertNull(solution.mergeTwoLists(null, null));
  }

  @Test
  void mergeTwoLists2() {
    assertTrue(same(ln(0), solution.mergeTwoLists(null, ln(0))));
  }
}
