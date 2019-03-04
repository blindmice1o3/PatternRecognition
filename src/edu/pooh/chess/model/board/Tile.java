package edu.pooh.chess.model.board;

import edu.pooh.chess.model.entity.Token;

import java.awt.*;

public class Tile {

    public static final int WIDTH = 64, HEIGHT = 64;

    private String id;
    private Color color;

    private Token token;
    private boolean border = false;

    private Rectangle bound;

    public Tile(String id, Color color) {
        this.id = id;
        this.color = color;
        bound = new Rectangle();
    }

    // GETTERS & SETTERS

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public Rectangle getBound() {
        return bound;
    }

    public String getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

} // **** end Tile class ****