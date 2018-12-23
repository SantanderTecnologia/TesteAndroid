package com.seletiva.santander.investment.Models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class CellTest {
    private Cell singleCell;

    @Before
    public void setUp() {
        singleCell = new Cell();
    }

    @Test
    public void testCellNotNull() {
        assertNotNull(singleCell);
    }

    @Test
    public void testCellType() {
        singleCell.setType(CellType.field);

        assertThat(singleCell.getType(), is(equalTo(CellType.field)));
        assertThat(singleCell.getType(), is(not(equalTo(CellType.image))));
    }
}