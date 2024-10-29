package main.java.datastructure.soft;

public class InsertSoft {
    public static void main(String[] args) {
//        int[] number = new int[8000];
        int[] test = {3, 1, 9, 2};
        int j;
        for (int i = 1; i < test.length; i++) {
            int temp = test[i];
            for (j = i - 1; j >= 0 && test[j] > temp; j--) {
                test[j + 1] = test[j];
            }
            test[j + 1] = temp;
        }
    }

}
