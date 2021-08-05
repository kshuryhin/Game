package main;

public class MoveLeftTest {
    public static void main(String[] args) {
        int[][] matrix = {{0, 2, 4, 0},
                         { 2, 2, 4, 4},
                           {0, 0, 2, 4},
                           {2, 2, 0, 4}
        };


//        for (int i = 0; i < 4; i++) {
//            moveZeroes(matrix[i]);
//            for (int j = 0; j < 3; j++) {
//                if (matrix[i][j] == matrix[i][j+1]) {
//                    matrix[i][j] = matrix[i][j] * 2;
//                    matrix[i][j+1] = 0;
//                    j++;
//                }
//            }
//            moveZeroes(matrix[i]);
//        }




        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void moveZeroes (int[] matrix) {
        int pos = 0;
        for(int i = 0;i < matrix.length;i++) {
            if(matrix[i] != 0) {
                if(i != pos) {
                    matrix[pos] = matrix[i];
                    matrix[i] = 0;
                }
                pos++;
            }
        }
        }


    }

