public class MoveTopTest {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int temp = 0;
        matrix[3][0] = 2;
        matrix[2][2] = 4;
        matrix[0][1] = 4;
        matrix[1][3] = 2;

        for (int j = 0; j < matrix[0].length ; j++) {
            for (int i = matrix.length-1; i > 0; i--) {
                if (matrix[i][j] != 0 && matrix[i-1][j] == 0) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i-1][j];
                    matrix[i-1][j] = temp;
                }

                if (matrix[i][j] == matrix[i-1][j]) {
                    matrix[i][j] = 0;
                    matrix[i-1][j] = matrix[i-1][j]*2;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
