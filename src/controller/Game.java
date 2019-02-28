package controller;

import model.board.Board;
import view.Displayer;

public class Game {

    private Displayer displayer;
    private Board board;

    public Game() {

        board = new Board();
        displayer = new Displayer(this);

        initGame();

    } // **** end controller.Game() constructor ****



    public Board getBoard() {
        return board;
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        new Game();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

} // **** end controller.Game class ****