package io.github.csc130.checkers;

public enum CheckerPiece implements Piece{
        RED_CHECKER("X"), RED_KING, BLACK_CHECKER, BLACK_KING, BLANK_SPACE;

    @Override
    public String getName() {
        return this.name().toString();
    }
}
