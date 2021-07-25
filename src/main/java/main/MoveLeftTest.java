package main;

public class MoveLeftTest {
    public static void main(String[] args) {
//        int[][] matrix = {0, 0, 4, 2};
        int count = 0;
        int temp = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int  j = matrix[i].length - 1; j > 0 ; j--) {
                if (matrix[i][j] != 0 && matrix[i][j-1] == 0) {
                    temp = matrix[i][j-1];
                    matrix[i][j-1] = matrix[i][j];
                    matrix[i][j] = temp;
                }
                    if (matrix[i][j] != 0 && count == 0 && matrix[i][j] == matrix[i][j-1]) {
                        matrix[i][j-1] = matrix[i][j]*2;
                        matrix[i][j] = 0;
                        count++;
                    }
            }
            count = 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
