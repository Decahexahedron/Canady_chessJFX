package canady_chessjfx;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class Rook extends Piece {

    private int x, y;
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
            int cx = this.x - i;
            int cy = this.y;
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (check(p, this.x - i, this.y)) {
                    if (!p.getColor().equals(this.color)) {
                        bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                            @Override
                            public void handle(ActionEvent event) {
                                Piece e = null;
                                for (Piece p : Canady_ChessJFX.wlist) {
                                    if (check(p, cx, cy)) {
                                        e = p;
                                    }
                                }
                                if (e != null) {
                                    Canady_ChessJFX.wlist.remove(e);
                                }
                                move(cx, cy);
                                Canady_ChessJFX.resetBoard(bbb);
                            }
                        });
                        bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                    }
                    i = this.x;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (check(p, this.x - i, this.y)) {
                    if (!p.getColor().equals(this.color)) {
                        bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                            @Override
                            public void handle(ActionEvent event) {
                                Piece e = null;
                                for (Piece p : Canady_ChessJFX.blist) {
                                    if (check(p, cx, cy)) {
                                        e = p;
                                    }
                                }
                                if (e != null) {
                                    Canady_ChessJFX.blist.remove(e);
                                }
                                move(cx, cy);
                                Canady_ChessJFX.resetBoard(bbb);
                            }
                        });
                        bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                    }
                    i = this.x;
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
                bbb[this.x - i][this.y].setText("o");
            }
        }

        for (int i = 1; i <= 7 - this.x; i++) { // dn
            int cx = this.x + i;
            int cy = this.y;
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (check(p, this.x + i, this.y)) {
                    if (!p.getColor().equals(this.color)) {
                        bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                            @Override
                            public void handle(ActionEvent event) {
                                Piece e = null;
                                for (Piece p : Canady_ChessJFX.wlist) {
                                    if (check(p, cx, cy)) {
                                        e = p;
                                    }
                                }
                                if (e != null) {
                                    Canady_ChessJFX.wlist.remove(e);
                                }
                                move(cx, cy);
                                Canady_ChessJFX.resetBoard(bbb);
                            }
                        });
                        bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                    }
                    i = 7 - this.x;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (check(p, this.x + i, this.y)) {
                    if (!p.getColor().equals(this.color)) {
                        bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                            @Override
                            public void handle(ActionEvent event) {
                                Piece e = null;
                                for (Piece p : Canady_ChessJFX.blist) {
                                    if (check(p, cx, cy)) {
                                        e = p;
                                    }
                                }
                                if (e != null) {
                                    Canady_ChessJFX.blist.remove(e);
                                }
                                move(cx, cy);
                                Canady_ChessJFX.resetBoard(bbb);
                            }
                        });
                        bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                    }
                    i = 7 - this.x;
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
                bbb[this.x + i][this.y].setText("o");
            }
        }

        for (int i = 1; i <= this.y; i++) { // lf
            int cx = this.x;
            int cy = this.y - i;
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (check(p, this.x, this.y - i)) {
                    if (!p.getColor().equals(this.color)) {
                        bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                            @Override
                            public void handle(ActionEvent event) {
                                Piece e = null;
                                for (Piece p : Canady_ChessJFX.wlist) {
                                    if (check(p, cx, cy)) {
                                        e = p;
                                    }
                                }
                                if (e != null) {
                                    Canady_ChessJFX.wlist.remove(e);
                                }
                                move(cx, cy);
                                Canady_ChessJFX.resetBoard(bbb);
                            }
                        });
                        bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                    }
                    i = this.y;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (check(p, this.x, this.y - i)) {
                    if (!p.getColor().equals(this.color)) {
                        bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                            @Override
                            public void handle(ActionEvent event) {
                                Piece e = null;
                                for (Piece p : Canady_ChessJFX.blist) {
                                    if (check(p, cx, cy)) {
                                        e = p;
                                    }
                                }
                                if (e != null) {
                                    Canady_ChessJFX.blist.remove(e);
                                }
                                move(cx, cy);
                                Canady_ChessJFX.resetBoard(bbb);
                            }
                        });
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
                bbb[this.x][this.y - i].setText("o");
            }
        }

        for (int i = 1; i < 7 - this.y; i++) { // rt
            int cx = this.x;
            int cy = this.y + i;
            there = false;
            for (Piece p : Canady_ChessJFX.wlist) {
                if (check(p, this.x, this.y + i)) {
                    if (!p.getColor().equals(this.color)) {
                        bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                            @Override
                            public void handle(ActionEvent event) {
                                Piece e = null;
                                for (Piece p : Canady_ChessJFX.wlist) {
                                    if (check(p, cx, cy)) {
                                        e = p;
                                    }
                                }
                                if (e != null) {
                                    Canady_ChessJFX.wlist.remove(e);
                                }
                                move(cx, cy);
                                Canady_ChessJFX.resetBoard(bbb);
                            }
                        });
                        bbb[p.getX()][p.getY()].setTextFill(Color.GREEN);
                    }
                    i = 7 - this.y;
                    there = true;
                }
            }
            for (Piece p : Canady_ChessJFX.blist) {
                if (check(p, this.x, this.y + i)) {
                    if (!p.getColor().equals(this.color)) {
                        bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                            @Override
                            public void handle(ActionEvent event) {
                                Piece e = null;
                                for (Piece p : Canady_ChessJFX.blist) {
                                    if (check(p, cx, cy)) {
                                        e = p;
                                    }
                                }
                                if (e != null) {
                                    Canady_ChessJFX.blist.remove(e);
                                }
                                move(cx, cy);
                                Canady_ChessJFX.resetBoard(bbb);
                            }
                        });
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
                bbb[this.x][this.y + i].setText("o");
            }
        }
    }
}
