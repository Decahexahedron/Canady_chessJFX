package canady_chessjfx;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class Bishop extends Piece {

    private int x, y;
    private char symbol;
    final private String color;

    public Bishop(int a, int b, String d) {
        this.x = a;
        this.y = b;
        this.color = d;
        if (this.color.equals("w")) {
            this.symbol = '♗';
        } else if (this.color.equals("b")) {
            this.symbol = '♝';
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

        if (this.x > 0 && this.y > 0) {
            for (int i = 1; i <= this.y; i++) { // up left
                int cx = this.x - i;
                int cy = this.y - i;
                there = false;
                for (Piece p : Canady_ChessJFX.wlist) {
                    if (p.getX() == this.x - i && p.getY() == this.y - i) {
                        if (!p.getColor().equals(this.color)) {
                            bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                        }
                        i = this.y;
                        there = true;
                    }
                }
                for (Piece p : Canady_ChessJFX.blist) {
                    if (p.getX() == this.x - i && p.getY() == this.y - i) {
                        if (!p.getColor().equals(this.color)) {
                            bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                        }
                        i = this.y;
                        there = true;
                    }
                }
                if (!there) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[this.x - i][this.y - i].setText("o");
                }
            }
        }

        if (this.x < 7 && this.y > 0) {
            for (int i = 1; i <= this.y; i++) { // dn left
                int cx = this.x + i;
                int cy = this.y - i;
                there = false;
                for (Piece p : Canady_ChessJFX.wlist) {
                    if (p.getX() == this.x + i && p.getY() == this.y - i) {
                        if (!p.getColor().equals(this.color)) {
                            bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                        }
                        i = this.y;
                        there = true;
                    }
                }
                for (Piece p : Canady_ChessJFX.blist) {
                    if (p.getX() == this.x + i && p.getY() == this.y - i) {
                        if (!p.getColor().equals(this.color)) {
                            bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                        }
                        i = this.y;
                        there = true;
                    }
                }
                if (!there) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[this.x + i][this.y - i].setText("o");
                }
            }
        }

        if (this.x > 0 && this.y < 7) {
            for (int i = 1; i < 8 - this.y; i++) { // up right
                int cx = this.x - i;
                int cy = this.y + i;
                there = false;
                for (Piece p : Canady_ChessJFX.wlist) {
                    if (p.getX() == this.x - i && p.getY() == this.y + i) {
                        if (!p.getColor().equals(this.color)) {
                            bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                        }
                        i = 7 - this.y;
                        there = true;
                    }
                }
                for (Piece p : Canady_ChessJFX.blist) {
                    if (p.getX() == this.x - i && p.getY() == this.y + i) {
                        if (!p.getColor().equals(this.color)) {
                            bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                        }
                        i = 7 - this.y;
                        there = true;
                    }
                }
                if (!there) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[this.x - i][this.y + i].setText("o");
                }
            }
        }

        if (this.x < 7 && this.y < 7) {
            for (int i = 1; i < 8 - this.y; i++) { // dn right
                int cx = this.x + i;
                int cy = this.y + i;
                there = false;
                for (Piece p : Canady_ChessJFX.wlist) {
                    if (p.getX() == this.x + i && p.getY() == this.y + i) {
                        if (!p.getColor().equals(this.color)) {
                            bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                        }
                        i = 7 - this.y;
                        there = true;
                    }
                }
                for (Piece p : Canady_ChessJFX.blist) {
                    if (p.getX() == this.x + i && p.getY() == this.y + i) {
                        if (!p.getColor().equals(this.color)) {
                            bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                        }
                        i = 7 - this.y;
                        there = true;
                    }
                }
                if (!there) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[this.x + i][this.y + i].setText("o");
                }
            }
        }
    }

}
