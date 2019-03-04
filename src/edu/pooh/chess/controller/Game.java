package edu.pooh.chess.controller;

import edu.pooh.chess.model.board.Board;
import edu.pooh.chess.view.Displayer;

public class Game {

    private Displayer displayer;
    private Board board;

    public Game() {

        board = new Board();
        displayer = new Displayer(this);


    } // **** end edu.pooh.chess.controller.Game() constructor ****



    public Board getBoard() {
        return board;
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        new Game();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

} // **** end edu.pooh.chess.controller.Game class ****