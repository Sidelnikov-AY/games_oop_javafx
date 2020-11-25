package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        int size = Math.abs(dest.getX() - position().getX());;
        int x = 0;
        int y = 0;
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > position().getX() ? 1: -1;
        int deltaY = dest.getY() > position().getY() ? 1: -1;
        if (Math.abs(dest.getX() - position().getX()) != Math.abs(dest.getY() - position().getY())) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        } else {
            for (int index = 0; index < size; index++) {
                if (deltaX == 1) {
                    x = index + deltaX + 2;
                    y = 7 - index - deltaY - 2;
                } else {
                    x = 7 - index + deltaX - 2;
                    y = 7 - index + deltaY;
                    }
                steps[index] = Cell.findBy(x, y);
            }
        }

        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
