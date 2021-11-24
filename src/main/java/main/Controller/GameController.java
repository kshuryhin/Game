package main.Controller;

import main.Model.FileRepository;
import main.Model.Grid;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class GameController {
    private int[][] matrix;
    private int size;
    private Random rand = new Random(System.currentTimeMillis());

    public GameController(Grid grid){
        this.matrix = grid.getGrid();
        this.size = matrix.length;
    }

    public static String zeroCheck(int x) {
        if (x == 0) {
            return "";
        }
        return String.valueOf(x);
    }

    public int score() {

        int maxValue = matrix[0][0];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                }
            }
        }
        return maxValue;
    }

    public void moveLeft() {

        for (int i = 0; i < 4; i++) {
            moveZeroes(matrix[i]);
            sumElements(matrix[i]);
            moveZeroes(matrix[i]);
        }
    }

    public void moveZeroes(int[] arr) {
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != pos) {
                    arr[pos] = arr[i];
                    arr[i] = 0;

                }
                pos++;
            }
        }
    }

    public void sumElements(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && arr[i] != 0) {
                arr[i] = arr[i + 1] * 2;
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    public void addNewNumbers() {
        int[] arr1 = {2,4};
        int x;
        int y;
        if (containsNull()) {
            do {
                x = rand.nextInt(4);
                y = rand.nextInt(4);
            } while (matrix[x][y] != 0);
            matrix[x][y] = arr1[rand.nextInt(2)];
        }

    }

    public boolean containsNull() {
        boolean answer = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    answer = true;
                    break;
                }
            }
        }
        return answer;
    }

    public void start() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
        addNewNumbers();
        addNewNumbers();
    }

    public void moveUp() {
        int[] invert = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = matrix[j][i];
            }

            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);

            for (int j = 0; j < 4; j++) {
                matrix[j][i] = invert[j];
            }
        }
    }

    public void moveRight() {
        int[] invert = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = matrix[i][invert.length - 1 - j];
            }
            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = invert[invert.length - 1 - j];
            }
        }
    }

    public void moveDown() {
        int[] invert = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = matrix[invert.length - 1 - j][i];
            }

            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);

            for (int j = 0; j < 4; j++) {
                matrix[j][i] = invert[invert.length - 1 - j];
            }
        }
    }

    public void saveGame(){
//        MySQLRepository dbRepo = new MySQLRepository(matrix);
//        dbRepo.save(matrix);

        FileRepository fileRepo = new FileRepository(matrix);
        fileRepo.save(matrix);
    }

    public void uploadGame() throws IOException, SQLException {
//        MySQLRepository dbRepo = new MySQLRepository(matrix);
//        dbRepo.load();
        FileRepository fileRepo = new FileRepository(matrix);
        fileRepo.load();
    }
}