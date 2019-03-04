package edu.pooh.chess.model.board;


import edu.pooh.chess.model.entity.Token;

import java.awt.*;

public class Board {

    public enum Rank {
        ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"); // Named constants.

        private String rank;                                                                    // Private variable.

        Rank(String rank) {                                                                     // Constructor.
            this.rank = rank;
        }

        public String getRank() {                                                               // Getter method.
            return rank;
        }
    }

    public enum File { A, B, C, D, E, F, G, H }

    private int row = Rank.values().length;
    private int column = File.values().length;

    private Tile[][] tiles;

    public Board() {
        tiles = new Tile[row][column];

        initBoard();
        setTokens();
    }

    public void initBoard() {
        int rowIndex = row-1;
        int columnIndex = 0;
        Color color;

        for (Rank rank : Rank.values()) {
            for (File file: File.values()) {

                // rowIndex's is ODD. pattern: DARK then LIGHT
                if (rowIndex % 2 == 1) {
                    // dark, light, dark, light, dark, light, dark, light
                    if (columnIndex % 2 == 0) {
                        color = Color.BLUE;
                    } else {
                        color = Color.YELLOW;
                    }
                    // !!!Tile INSTANTIATION!!!
                    tiles[rowIndex][columnIndex] = new Tile(rank.getRank() + file.toString(), color);
                }
                // rowIndex is EVEN. pattern: LIGHT then DARK
                else {
                    // light, dark, light, dark, light, dark, light, dark
                    if (columnIndex % 2 == 0) {
                        color = Color.YELLOW;
                    } else {
                        color = Color.BLUE;
                    }
                    // !!!Tile INSTANTIATION!!!
                    tiles[rowIndex][columnIndex] = new Tile(rank.getRank() + file.toString(), color);
                }

                columnIndex++;               // Increment the column index.
            } // end inner for-loop

            // Reset the columnIndex for iterating through the next row (Rank).
            columnIndex = 0;
            rowIndex--;                      // !!!DECREMENT!!! the row index.
        } // end outer for-loop
    }

    public void setTokens() {
        for (Tile[] ti : tiles) {
            for (Tile t : ti) {
                // Create and set BLACK tokens.
                if (t.getId().charAt(0) == '8' || t.getId().charAt(0) == '7' || t.getId().charAt(0) == '6') {
                    if (t.getColor() == Color.BLUE) {
                        t.setToken( new Token(Color.BLACK) );   // Token instantiation PLAYER2.
                    }
                }
                else if (t.getId().charAt(0) == '3' || t.getId().charAt(0) == '2' || t.getId().charAt(0) == '1') {
                    if (t.getColor() == Color.BLUE) {
                        t.setToken( new Token(Color.WHITE) );   // Token instantiation PLAYER1.
                    }
                }
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
