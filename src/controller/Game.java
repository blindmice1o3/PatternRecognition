package controller;

import view.Displayer;

public class Game {

    Displayer displayer;

    public Game() {
        displayer = new Displayer();
    } // **** end controller.Game() constructor ****

    public static void main(String[] args) {
        new Game();
    }

} // **** end controller.Game class ****