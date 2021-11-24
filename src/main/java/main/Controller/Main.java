package main.Controller;

import main.Model.Grid;
import main.View.MainView;

public class Main {
    public static void main(String[] args) {
        Grid game = new Grid(4);
        MainView mainView = new MainView(new Grid(4));
//        System.out.println(game.getSize());
    }
}
