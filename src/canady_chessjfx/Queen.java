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
        boolean there;
        for (int i = 1; i <= this.x; i++) { // up
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (check(p, this.x - i, this.y)) {
                    i = this.x;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (check(p, this.x - i, this.y)) {
                    i = this.x;
                    there = true;
                }
            }
            if (!there) {
                bbb[this.x - i][this.y].setText("o");
            }
        }

        for (int i = 1; i <= 8 - this.x; i++) { // dn
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (check(p, this.x + i, this.y)) {
                    i = this.x;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (check(p, this.x + i, this.y)) {
                    i = this.x;
                    there = true;
                }
            }
            if (!there) {
                bbb[this.x + i][this.y].setText("o");
            }
        }

        for (int i = 1; i <= this.y; i++) { // lf
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (check(p, this.x - i, this.y)) {
                    i = this.y;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (check(p, this.x - i, this.y)) {
                    i = this.y;
                    there = true;
                }
            }
            if (!there) {
                bbb[this.x][this.y - i].setText("o");
            }
        }

        for (int i = 1; i < 8 - this.y; i++) { // rt
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (check(p, this.x, this.y + i)) {
                    i = this.y;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (check(p, this.x, this.y + i)) {
                    i = this.y;
                    there = true;
                }
            }
            if (!there) {
                bbb[this.x][this.y + i].setText("o");
            }
        }
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
