package algorithm.array;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                exchange(matrix, i, j, j, matrix.length - 1 - i);
                exchange(matrix, i, j, matrix.length - 1 - i, matrix.length - 1 - j);
                exchange(matrix, i, j, matrix.length - 1 - j, i);
            }
        }
    }

    public static void exchange(int[][] matrix, int i1, int j1, int i2, int j2) {
        matrix[i1][j1] = matrix[i1][j1] + matrix[i2][j2];
        matrix[i2][j2] = matrix[i1][j1] - matrix[i2][j2];
        matrix[i1][j1] = matrix[i1][j1] - matrix[i2][j2];
    }
}



