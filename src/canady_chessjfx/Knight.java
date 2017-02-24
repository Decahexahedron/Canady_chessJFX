package canady_chessjfx;

import javafx.scene.control.*;

public class Knight extends Piece {

    private int x, y;
    private int a, b;
    private char symbol;
    private final String color;

    public Knight(int a, int b, String d) {
        this.x = a;
        this.y = b;
        this.color = d;
        if (this.color.equals("w")) {
            this.symbol = '♘';
        } else if (this.color.equals("b")) {
            this.symbol = '♞';
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
        boolean[][] ppp = new boolean[2][8];
        for (Piece p : Canady_ChessJFX.wlist) {
            if (p.getX() == this.x - 2 && p.getY() == this.y - 1) {
                ppp[0][0] = false;
            }
            if (p.getX() == this.x - 2 && p.getY() == this.y + 1) {
                ppp[0][1] = false;
            }
            if (p.getX() == this.x + 2 && p.getY() == this.y - 1) {
                ppp[0][2] = false;
            }
            if (p.getX() == this.x + 2 && p.getY() == this.y + 1) {
                ppp[0][3] = false;
            }
            if (p.getX() == this.x - 1 && p.getY() == this.y - 2) {
                ppp[0][4] = false;
            }
            if (p.getX() == this.x + 1 && p.getY() == this.y - 2) {
                ppp[0][5] = false;
            }
            if (p.getX() == this.x - 1 && p.getY() == this.y + 2) {
                ppp[0][6] = false;
            }
            if (p.getX() == this.x + 1 && p.getY() == this.y + 2) {
                ppp[0][7] = false;
            }
        }
        for (Piece p : Canady_ChessJFX.blist) {
            if (p.getX() == this.x - 2 && p.getY() == this.y - 1) {
                ppp[1][0] = false;
            }
            if (p.getX() == this.x - 2 && p.getY() == this.y + 1) {
                ppp[1][1] = false;
            }
            if (p.getX() == this.x + 2 && p.getY() == this.y - 1) {
                ppp[1][2] = false;
            }
            if (p.getX() == this.x + 2 && p.getY() == this.y + 1) {
                ppp[1][3] = false;
            }
            if (p.getX() == this.x - 1 && p.getY() == this.y - 2) {
                ppp[1][4] = false;
            }
            if (p.getX() == this.x + 1 && p.getY() == this.y - 2) {
                ppp[1][5] = false;
            }
            if (p.getX() == this.x - 1 && p.getY() == this.y + 2) {
                ppp[1][6] = false;
            }
            if (p.getX() == this.x + 1 && p.getY() == this.y + 2) {
                ppp[1][7] = false;
            }
        }

        if (this.x > 1) { // top ones
            if (this.y > 0 && ppp[0][0] && ppp[1][0]) {
                bbb[this.x - 2][this.y - 1].setText("o");
            }
            if (this.y < 7 && ppp[0][1] && ppp[1][1]) {
                bbb[this.x - 2][this.y + 1].setText("o");
            }
        }

        if (this.x < 6) { // bottom ones
            if (this.y > 0 && ppp[0][2] && ppp[1][2]) {
                bbb[this.x + 2][this.y - 1].setText("o");
            }
            if (this.y < 7 && ppp[0][3] && ppp[1][3]) {
                bbb[this.x + 2][this.y + 1].setText("o");
            }
        }

        if (this.y > 1) { // left ones
            if (this.x > 0 && ppp[0][4] && ppp[1][4]) {
                bbb[this.x - 1][this.y - 2].setText("o");
            }
            if (this.x < 7 && ppp[0][5] && ppp[1][5]) {
                bbb[this.x + 1][this.y - 2].setText("o");
            }
        }

        if (this.y < 6) { // right ones
            if (this.x > 0 && ppp[0][6] && ppp[1][6]) {
                bbb[this.x - 1][this.y + 2].setText("o");
            }
            if (this.x < 7 && ppp[0][7] && ppp[1][7]) {
                bbb[this.x + 1][this.y + 2].setText("o");
            }
        }
    }
}
