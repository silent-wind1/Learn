package algorithm.array;

// 螺旋矩阵
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][]  matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // 表示数组 上下左右 下标
        int left = 0, right = matrix[0].length - 1, top = 0, under = matrix.length - 1, index = 0;
        // 使用一个数组添加元素
        int[] array = new int[(right + 1) * (under + 1)];
        while (true) {
            // 从左边往右添加
            for (int i = left; i <= right; i++) {
                array[index++] = matrix[top][i];
            }
            if(++top > under) {
                break;
            }
            // 从上往下添加
            for (int i = top; i <= under; i++) {
                array[index++] = matrix[i][right];
            }

            if(left > --right) {
                break;
            }
            // 从右边往左
            for (int i = right; i >= left; i--) {
                array[index++] = matrix[under][i];
            }

            if(top > --under) {
                break;
            }
            // 从下往上
            for (int i = under; i >= top; i--) {
                array[index++] = matrix[i][left];
            }
            if(++left > right) {
                break;
            }
        }

        for (int i : array) {
            System.out.print(i + "\t");
        }
    }
}
