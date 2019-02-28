package model.board;

import model.entity.Token;

import java.awt.*;

public class Tile {

    public static final int WIDTH = 32, HEIGHT = 32;

    private String id;
    private Color color;

    private Token token;

    public Tile(String id, Color color) {
        this.id = id;
        this.color = color;
    }

    // GETTERS & SETTERS

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