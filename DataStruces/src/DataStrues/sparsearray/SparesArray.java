package DataStrues.sparsearray;

public class SparesArray {
    public static void main(String[] args) {
        int[][] chessArr1 = new int[6][6];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        chessArr1[1][4] = -20;
        chessArr1[3][5] = 30;
        chessArr1[0][1] = 80;
        chessArr1[4][1] = 100;
        for (int[] ints : chessArr1) {
            for (int item : ints) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }

        // 将二维数组转换成稀疏数组
        // 先遍历二维数组得到非0的数据个数
        int sum = 0;
        for (int[] ints : chessArr1) {
            for (int item : ints) {
                if(item != 0) {
                    sum++;
                }
            }
        }

        // 创建稀疏数组
        int[][] sparseArray = new int[sum +  1][3];
        sparseArray[0][0] = 6;
        sparseArray[0][1] = 6;
        sparseArray[0][2] = sum;
        int index = 1; // 用于记录是第几个非0数据
        //  先遍历二维数组得到非0的数据存储到稀疏数组中
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(chessArr1[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = chessArr1[i][j];
                    index++;
                }
            }
        }

        System.out.println("-------------稀疏数组--------------");
        // 遍历稀疏数组
        for (int[] ints : sparseArray) {
            for (int item : ints) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }


        // 将稀疏数组转换成普通数组
        int[][] Array = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            Array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("-----------稀疏数组转换成普通数组------------");
        for (int[] ints : Array) {
            for (int item : ints) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }
}
