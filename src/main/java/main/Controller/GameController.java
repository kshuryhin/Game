package main.Controller;

import main.Model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.PriorityQueue;
import java.util.Random;

public class GameController {
    private Grid grid;
    private int size;
    private Random rand = new Random(System.currentTimeMillis());
    Score score;

    //хранить не matrix, а Grid
    public GameController(Grid grid){
        this.grid = grid;
        this.size = grid.getSize();
        this.score = score;
    }

    public static String zeroCheck(int x) {
        if (x == 0) {
            return "";
        }
        return String.valueOf(x);
    }

    //сделать score суммой всех элементов. Сохранение score в базу данных
    public int score() {
        int maxValue = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                    maxValue += grid.getGrid()[i][j];
            }
        }
        return maxValue;
    }

    public void saveScore() throws SQLException {
        int score = score();
        PriorityQueue<Integer> queue = DataBase.getScore();
        queue.add(score);
        DataBase.updateScore(queue);
    }

    public int getRecord() throws SQLException {
        return DataBase.getScore().peek();
    }

    public void moveLeft() {

        for (int i = 0; i < 4; i++) {
            moveZeroes(grid.getGrid()[i]);
            sumElements(grid.getGrid()[i]);
            moveZeroes(grid.getGrid()[i]);
        }
        addNewNumbers();
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
            } while (grid.getGrid()[x][y] != 0);
            grid.getGrid()[x][y] = arr1[rand.nextInt(2)];
        }

    }

    public boolean containsNull() {
        boolean answer = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid.getGrid()[i][j] == 0) {
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
                grid.getGrid()[i][j] = 0;
            }
        }
        addNewNumbers();
        addNewNumbers();
    }

    //создать метода для вызова трех
    public void moveUp() {
        int[] invert = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = grid.getGrid()[j][i];
            }

            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);

            for (int j = 0; j < 4; j++) {
                grid.getGrid()[j][i] = invert[j];
            }
        }
        addNewNumbers();
    }

    public void moveRight() {
        int[] invert = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = grid.getGrid()[i][invert.length - 1 - j];
            }
            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);
            for (int j = 0; j < 4; j++) {
                grid.getGrid()[i][j] = invert[invert.length - 1 - j];
            }
        }
        addNewNumbers();
    }

    public void moveDown() {
        int[] invert = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                invert[j] = grid.getGrid()[invert.length - 1 - j][i];
            }

            moveZeroes(invert);
            sumElements(invert);
            moveZeroes(invert);

            for (int j = 0; j < 4; j++) {
                grid.getGrid()[j][i] = invert[invert.length - 1 - j];
            }
        }
        addNewNumbers();
    }

    public void saveGame() throws IOException, ClassNotFoundException, SQLException {
        MySQLRepository dbRepo = new MySQLRepository();
        dbRepo.save(grid);
        saveScore();
    }

    public void uploadGame() throws IOException, SQLException, ClassNotFoundException {
        MySQLRepository dbRepo = new MySQLRepository();
        dbRepo.load(grid);
    }
}
