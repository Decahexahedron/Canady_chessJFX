package canady_chessjfx;

import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class Pawn extends Piece {

    private int x, y;
    private int a, b;
    private char symbol;
    private final String color;

    public Pawn(int a, int b, String d) {
        this.x = a;
        this.y = b;
        this.color = d;
        if (this.color.equals("w")) {
            this.symbol = '♙';
        } else if (this.color.equals("b")) {
            this.symbol = '♟';
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
        this.x = ax;
        this.y = ay;
    }

    @Override
    public void display(Button[][] bbb) {
        if (this.color.equals("w")) { // white
            if (this.x == 1) {
                boolean m = true;
                boolean m1 = true;
                for (Piece p : Canady_ChessJFX.wlist) {
                    if (check(p, this.x + 1, this.y)) {
                        m = false;
                    }
                    if (check(p, this.x + 2, this.y)) {
                        m1 = false;
                    }
                }
                for (Piece p : Canady_ChessJFX.blist) {
                    if (check(p, this.x + 1, this.y)) {
                        m = false;
                    }
                    if (check(p, this.x + 2, this.y)) {
                        m1 = false;
                    }
                }
                if (m) {
                    bbb[this.x + 1][this.y].setText("o");
                }
                if (m1) {
                    bbb[this.x + 2][this.y].setText("o");
                }
            } else {
                boolean m = true;
                for (Piece p : Canady_ChessJFX.wlist) {
                    if (check(p, this.x + 1, this.y)) {
                        m = false;
                    }
                }
                for (Piece p : Canady_ChessJFX.blist) {
                    if (check(p, this.x + 1, this.y)) {
                        m = false;
                    }
                }
                if (m) {
                    bbb[this.x + 1][this.y].setText("o");
                }
            }
            //                  insert enemy check here

        } else // black
        {
            if (this.x == 6) {
                boolean m = true;
                boolean m1 = true;
                for (Piece p : Canady_ChessJFX.wlist) {
                    if (check(p, this.x - 1, this.y)) {
                        m = false;
                    }
                    if (check(p, this.x - 2, this.y)) {
                        m1 = false;
                    }
                }
                for (Piece p : Canady_ChessJFX.blist) {
                    if (check(p, this.x - 1, this.y)) {
                        m = false;
                    }
                    if (check(p, this.x - 2, this.y)) {
                        m1 = false;
                    }
                }
                if (m) {
                    bbb[this.x - 1][this.y].setText("o");
                }
                if (m1) {
                    bbb[this.x - 2][this.y].setText("o");
                }
            } else {
                boolean m = true;
                for (Piece p : Canady_ChessJFX.wlist) {
                    if (check(p, this.x - 1, this.y)) {
                        m = false;
                    }
                }
                for (Piece p : Canady_ChessJFX.blist) {
                    if (check(p, this.x - 1, this.y)) {
                        m = false;
                    }
                }
                if (m) {
                    bbb[this.x - 1][this.y].setText("o");
                }
            } //                  insert enemy check here
        }
    }
}
