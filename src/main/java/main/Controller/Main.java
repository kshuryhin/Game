package main.Controller;

import main.Model.Grid;
import main.View.MainView;

public class Main {
    private final static int size = 4;
    public static void main(String[] args) {
        Grid game = new Grid(size);
        MainView mainView = new MainView(game);
        mainView.setVisible(true);
    }
}
