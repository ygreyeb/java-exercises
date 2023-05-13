package io.nuevedejun.leetcode.obstaclecourse;

import org.junit.jupiter.api.Test;

import static io.nuevedejun.leetcode.utils.TestUtils.fromFile;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

  final Solution solution = new Solution();

  @Test
  void longestObstacleCourseAtEachPosition0() {
    assertArrayEquals(new int[]{1, 2, 3, 3}, solution.longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2}));
  }

  @Test
  void longestObstacleCourseAtEachPosition1() {
    assertArrayEquals(new int[]{1, 2, 1}, solution.longestObstacleCourseAtEachPosition(new int[]{2, 2, 1}));
  }

  @Test
  void longestObstacleCourseAtEachPosition2() {
    assertArrayEquals(new int[]{1, 1, 2, 3, 2, 2}, solution.longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2}));
  }

  @Test
  void longestObstacleCourseAtEachPosition3() {
    assertArrayEquals(new int[]{1, 1, 2, 3, 2, 3, 4, 5, 3, 5}, solution.longestObstacleCourseAtEachPosition(new int[]{5, 1, 5, 5, 1, 3, 4, 5, 1, 4}));
  }

  @Test
  void longestObstacleCourseAtEachPosition4() throws Exception {
    testReadingFromFile("obstacle-course-test4.txt");
  }

  @Test
  void longestObstacleCourseAtEachPosition5() throws Exception {
    testReadingFromFile("obstacle-course-test5.txt");
  }

  private void testReadingFromFile(final String name) throws Exception {
    fromFile(name, line -> {
      String[] strings = line.get().split(",");
      int[] obstacles = new int[strings.length];
      for (int i = 0; i < strings.length; i++) {
        obstacles[i] = Integer.parseInt(strings[i]);
      }

      strings = line.get().split(",");
      int[] expected = new int[strings.length];
      for (int i = 0; i < strings.length; i++) {
        expected[i] = Integer.parseInt(strings[i]);
      }

      assertArrayEquals(expected, solution.longestObstacleCourseAtEachPosition(obstacles));
    });
  }
}
