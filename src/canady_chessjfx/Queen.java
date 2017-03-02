package canady_chessjfx;

import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class Queen extends Piece {

    private int x, y;
    private int a, b;
    private char symbol;
    private final String color;

    public Queen(int a, int b, String d) {
        this.x = a;
        this.y = b;
        this.color = d;
        if (this.color.equals("w")) {
            this.symbol = '♕';
        } else if (this.color.equals("b")) {
            this.symbol = '♛';
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

    @Override
    public void display(Button[][] bbb) {
        boolean there;
        for (int i = 0; i <= this.y; i++) { // up left
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (p.getX() == this.x - i && p.getY() == this.y - i) {
                    i = this.y;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (p.getX() == this.x - i && p.getY() == this.y - i) {
                    i = this.y;
                    there = true;
                }
            }
            if (!there) {
                bbb[this.x - i][this.y - i].setText("o");
            }
        }

        for (int i = 0; i <= this.y; i++) { // dn left
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (p.getX() == this.x + i && p.getY() == this.y - i) {
                    i = this.y;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (p.getX() == this.x + i && p.getY() == this.y - i) {
                    i = this.y;
                    there = true;
                }
            }
            if (!there) {
                bbb[this.x + i][this.y - i].setText("o");
            }
        }

        for (int i = 0; i < 8 - this.y; i++) { // up right
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (p.getX() == this.x - i && p.getY() == this.y + i) {
                    i = 7 - this.y;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (p.getX() == this.x - i && p.getY() == this.y + i) {
                    i = 7 - this.y;
                    there = true;
                }
            }
            if (!there) {
                bbb[this.x - i][this.y + i].setText("o");
            }
        }

        for (int i = 0; i < 8 - this.y; i++) { // dn right
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (p.getX() == this.x + i && p.getY() == this.y + i) {
                    i = 7 - this.y;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (p.getX() == this.x + i && p.getY() == this.y + i) {
                    i = 7 - this.y;
                    there = true;
                }
            }
            if (!there) {
                bbb[this.x + i][this.y + i].setText("o");
            }
        }
    }
}
