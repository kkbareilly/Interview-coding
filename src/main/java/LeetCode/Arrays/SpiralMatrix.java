package LeetCode.Arrays;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpiralMatrix {
  public static void main(String[] args) {
    //
    Stream.of(generateMatrix(3)).flatMap(Stream::of).collect(Collectors.toSet()).forEach(i -> System.out.println(i));
    ;
  }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            // traverse from left to right
            for (int j = i; j < n - i; j++) {
                res[i][j] = count++;
            }
            // traverse from top to bottom
            for (int j= i + 1; j < n - i; j++) {
                res[j][n - i - 1] = count++;
            }
            //  traverse from right to left
            for (int j = i + 1; j < n - i;j++) {
                res[n - i - 1][n - j- 1] = count++;
            }
            //  traverse from bottom to top
            for (int j = i + 1; j < n - i - 1; j++) {
                res[n - j - 1][i] = count++;
            }
        }
        return res;
    }

    public int[][] generateMatrixx(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int row = 0;
        int col = 0;
        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            // change direction if next cell is non zero
            if (result[r][c] != 0) d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }
        return result;
    }
}
