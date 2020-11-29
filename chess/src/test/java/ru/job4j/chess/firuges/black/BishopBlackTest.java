package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void WhenPositionIsOk() {
        BishopBlack BB = new BishopBlack(Cell.C8);
        assertThat(BB.position(), is(Cell.C8));

    }

    @Test
    public void WhenCopyIsOk() {
        BishopBlack BB = new BishopBlack(Cell.C8);
        assertThat(BB.copy(Cell.C8).position(), is(Cell.C8));

    }

    @Test
    public void WhenWayIsOk() throws ImpossibleMoveException {
        BishopBlack BB = new BishopBlack(Cell.C1);
        Cell[] wayCell = BB.way(Cell.G5);
        Cell[] correctWay = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(wayCell, is(correctWay));

    }

    @Test
    public void WhenWayIsOk2() throws ImpossibleMoveException {
        BishopBlack BB = new BishopBlack(Cell.F1);
        Cell[] wayCell = BB.way(Cell.B5);
        Cell[] correctWay = new Cell[] {Cell.E2, Cell.D3, Cell.C4, Cell.B5};
        assertThat(wayCell, is(correctWay));

    }

    @Test (expected = ImpossibleMoveException.class)
    public void WhenWayIsNotOk() throws ImpossibleMoveException {
        BishopBlack BB = new BishopBlack(Cell.F1);
        BB.way(Cell.E5);


    }


}