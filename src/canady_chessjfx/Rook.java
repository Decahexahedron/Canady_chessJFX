package canady_chessjfx;

import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class Rook extends Piece {

    private int x, y;
    private int a, b;
    private char symbol;
    private final String color;

    public Rook(int a, int b, String d) {
        this.x = a;
        this.y = b;
        this.color = d;
        if (this.color.equals("w")) {
            this.symbol = '♖';
        } else if (this.color.equals("b")) {
            this.symbol = '♜';
        }
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public void move(int ax, int ay) {
        this.setX(this.x + (ax * a));
        this.setY(this.y + (ay * b));
    }
}
