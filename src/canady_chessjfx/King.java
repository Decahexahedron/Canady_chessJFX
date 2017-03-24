package canady_chessjfx;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class King extends Piece {

    private int x, y;
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
        this.x = ax;
        this.y = ay;
    }

    @Override
    public void display(Button[][] bbb) {

        boolean[][] ppp = new boolean[2][8];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                ppp[i][j] = false;
            }
        }

        for (Piece p : Canady_ChessJFX.wlist) {
            if (check(p, this.x - 1, this.y + 1)) {
                ppp[0][0] = true;
            }
            if (check(p, this.x + 1, this.y - 1)) {
                ppp[0][1] = true;
            }
            if (check(p, this.x - 1, this.y - 1)) {
                ppp[0][2] = true;
            }
            if (check(p, this.x + 1, this.y + 1)) {
                ppp[0][3] = true;
            }
            if (check(p, this.x - 1, this.y)) {
                ppp[0][4] = true;
            }
            if (check(p, this.x + 1, this.y)) {
                ppp[0][5] = true;
            }
            if (check(p, this.x, this.y - 1)) {
                ppp[0][6] = true;
            }
            if (check(p, this.x, this.y + 1)) {
                ppp[0][7] = true;
            }
        }

        for (Piece p : Canady_ChessJFX.blist) {
            if (check(p, this.x - 1, this.y + 1)) {
                ppp[1][0] = true;
            }
            if (check(p, this.x + 1, this.y - 1)) {
                ppp[1][1] = true;
            }
            if (check(p, this.x - 1, this.y - 1)) {
                ppp[1][2] = true;
            }
            if (check(p, this.x + 1, this.y + 1)) {
                ppp[1][3] = true;
            }
            if (check(p, this.x - 1, this.y)) {
                ppp[1][4] = true;
            }
            if (check(p, this.x + 1, this.y)) {
                ppp[1][5] = true;
            }
            if (check(p, this.x, this.y - 1)) {
                ppp[1][6] = true;
            }
            if (check(p, this.x, this.y + 1)) {
                ppp[1][7] = true;
            }
        }

        if (this.color.equals("w")) { // white

            if (this.x > 0 && this.y < 7) {
                int cx = this.x - 1;
                int cy = this.y + 1;
                if (ppp[1][0]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[0][0]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
            if (this.x < 7 && this.y > 0) {
                int cx = this.x + 1;
                int cy = this.y - 1;
                if (ppp[1][1]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[0][1]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }

            if (this.x > 0 && this.y > 0) {
                int cx = this.x - 1;
                int cy = this.y - 1;
                if (ppp[1][2]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[0][2]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
            if (this.x < 7 && this.y < 7) {
                int cx = this.x + 1;
                int cy = this.y + 1;
                if (ppp[1][3]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[0][3]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }

            if (this.x > 0) {
                int cx = this.x - 1;
                int cy = this.y;
                if (ppp[1][4]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[0][4]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
            if (this.x < 7) {
                int cx = this.x + 1;
                int cy = this.y;
                if (ppp[1][5]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[0][5]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }

            if (this.y > 0) {
                int cx = this.x;
                int cy = this.y - 1;
                if (ppp[1][6]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[0][6]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
            if (this.y < 7) {
                int cx = this.x;
                int cy = this.y + 1;
                if (ppp[1][7]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[0][7]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }

        } else { // black

            if (this.x > 0 && this.y < 7) {
                int cx = this.x - 1;
                int cy = this.y + 1;
                if (ppp[0][0]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[1][0]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
            if (this.x < 7 && this.y > 0) {
                int cx = this.x + 1;
                int cy = this.y - 1;
                if (ppp[0][1]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[1][1]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }

            if (this.x > 0 && this.y > 0) {
                int cx = this.x - 1;
                int cy = this.y - 1;
                if (ppp[0][2]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[1][2]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
            if (this.x < 7 && this.y < 7) {
                int cx = this.x + 1;
                int cy = this.y + 1;
                if (ppp[0][3]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[1][3]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }

            if (this.x > 0) {
                int cx = this.x - 1;
                int cy = this.y;
                if (ppp[0][4]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[1][4]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
            if (this.x < 7) {
                int cx = this.x + 1;
                int cy = this.y;
                if (ppp[0][5]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[1][5]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }

            if (this.y > 0) {
                int cx = this.x;
                int cy = this.y - 1;
                if (ppp[0][6]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[1][6]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
            if (this.y < 7) {
                int cx = this.x;
                int cy = this.y + 1;
                if (ppp[0][7]) {
                    bbb[cx][cy].setTextFill(Color.GREEN);
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
                } else if (!ppp[1][7]) {
                    bbb[cx][cy].setOnAction(new EventHandler<ActionEvent>() { //button action
                        @Override
                        public void handle(ActionEvent event) {
                            move(cx, cy);
                            Canady_ChessJFX.resetBoard(bbb);
                        }
                    });
                    bbb[cx][cy].setText("o");
                }
            }
        }

    }
}
