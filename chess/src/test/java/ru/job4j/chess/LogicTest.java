package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import org.junit.Test;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

import static org.junit.Assert.*;

public class LogicTest {

    @Test (expected = FigureNotFoundException.class)
    public void WhenMoveErrorFigureNotFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.move(Cell.C3, Cell.H3);
    }

    @Test (expected = OccupiedCellException.class)
    public void WhenMoveErrorCellOccup() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        logic.move(Cell.C1, Cell.E3);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void WhenMoveErrorImposMove() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.C2);
    }


}