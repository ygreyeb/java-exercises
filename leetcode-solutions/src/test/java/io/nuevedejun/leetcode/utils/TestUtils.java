package io.nuevedejun.leetcode.utils;

import java.util.stream.Stream;

public final class TestUtils {
  private TestUtils() {/* do not instantiate */}

  public static boolean same(ListNode... listNodes) {
    ListNode pivot = listNodes[0];
    boolean valMatch = Stream.of(listNodes).skip(1).allMatch(node -> {
      if (pivot == null) return node == null;
      else return pivot.val == node.val;
    });
    return valMatch && (pivot == null ||
        same(Stream.of(listNodes).map(node -> node.next).toArray(ListNode[]::new)));
  }

  public static ListNode ln(int... elements) {
    ListNode next = null;
    for (int i = elements.length - 1; i >= 0; i--) {
      next = new ListNode(elements[i], next);
    }
    return next;
  }

  public static int[][] m(int l, int... values) {
    int[][] matrix = new int[l][l];
    for (int i = 0; i < l; i++)
      System.arraycopy(values, i * l, matrix[i], 0, l);
    return matrix;
  }
}
