package io.nuevedejun.leetcode.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

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
    int height = values.length / l;
    int[][] matrix = new int[height][l];
    for (int i = 0; i < height; i++)
      System.arraycopy(values, i * l, matrix[i], 0, l);
    return matrix;
  }

  public static void fromFile(final String name, final UnhandledConsumer<UnhandledSupplier<String>> test) throws Exception {
    try (var reader = Files.newBufferedReader(
        Paths.get(requireNonNull(TestUtils.class.getClassLoader().getResource(name)).toURI()))) {
      test.accept(reader::readLine);
    }
  }

  @FunctionalInterface
  public interface UnhandledConsumer<T> {
    void accept(T t) throws Exception;
  }

  @FunctionalInterface
  public interface UnhandledSupplier<T> {
    T get() throws Exception;
  }
}
