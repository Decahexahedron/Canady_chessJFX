package canady_chessjfx;

import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class King extends Piece {

    private int x, y;
    private int a, b;
    private char symbol;
    private final String color;

    public King(int a, int b, String d) {
        this.x = a;
        this.y = b;
        this.color = d;
        if (this.color.equals("w")) {
            this.symbol = '♔';
        } else if (this.color.equals("b")) {
            this.symbol = '♚';
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
    public String getColor() {
        return this.color;
    }

    @Override
    public void move(int ax, int ay) {
        this.setX(ax);
        this.setY(ay);
    }
}
