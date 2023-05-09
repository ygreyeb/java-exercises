package io.nuevedejun.leetcode.spiralorder;

import java.util.AbstractList;
import java.util.List;

public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    return new SpiralList(matrix);
  }

  @SuppressWarnings("java:S2160")
  private static final class SpiralList extends AbstractList<Integer> implements List<Integer> {
    private final int[][] matrix;
    private final int m;
    private final int n;
    private final int size;
    private final int[] back;
    private boolean init = false;

    public SpiralList(int[][] matrix) {
      this.matrix = matrix;
      this.m = matrix.length;
      this.n = matrix[0].length;
      this.size = m * n;
      this.back = new int[size];
    }

    @Override
    public Integer get(int index) {
      if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
      if (!init) initialize();
      return back[index];
    }

    @SuppressWarnings("java:S3776")
    private void initialize() {
      int idx = 0;
      int top = 0;
      int bottom = m - 1;
      int left = 0;
      int right = n - 1;
      while (top <= bottom && left <= right) {
        //  right
        for (int i = left; i <= right; i++) {
          back[idx++] = matrix[top][i];
        }
        top++;
        //  down
        for (int i = top; i <= bottom; i++) {
          back[idx++] = matrix[i][right];
        }
        right--;
        //  left
        if (top <= bottom) {
          for (int i = right; i >= left; i--) {
            back[idx++] = matrix[bottom][i];
          }
          bottom--;
        }
        //  up
        if (left <= right) {
          for (int i = bottom; i >= top; i--) {
            back[idx++] = matrix[i][left];
          }
          left++;
        }
      }
      init = true;
    }

    @Override
    public int size() {
      return size;
    }
  }
}
