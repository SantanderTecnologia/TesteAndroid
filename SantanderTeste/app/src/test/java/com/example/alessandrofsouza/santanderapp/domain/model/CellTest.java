package com.example.alessandrofsouza.santanderapp.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CellTest {

    Cell cell;

    @Before
    public void init() {
        cell = new Cell();
        cell.setId(1);
        cell.setType(1);
        cell.setMessage("string");
        cell.setTypefield("string");
        cell.setHidden(true);
        cell.setTopSpacing(1);
        cell.setShow(1);
        cell.setRequired(true);
        cell.setEditTextValue("string");
    }

    @Test
    public void id_ReturnsTrue() {
        assertThat(cell.getId(), is(1));
    }

    @Test
    public void type_ReturnsTrue() {
        assertThat(cell.getType(), is(1));
    }

    @Test
    public void message_ReturnsTrue() {
        assertThat(cell.getMessage(), is("string"));
    }

    @Test
    public void message_ReturnsFalse() {
        assertEquals(cell.getMessage() == "", false);
    }

    @Test
    public void typeField_ReturnsTrue() {
        assertThat(cell.getTypefield(), is("string"));
    }

    @Test
    public void typeField_ReturnsFalse() {
        assertEquals(cell.getTypefield() == "", false);
    }

    @Test
    public void hidden_ReturnsTrue() {
        assertThat(cell.isHidden(), is(true));
    }

    @Test
    public void topSpacing_ReturnsTrue() {
        assertThat(cell.getTopSpacing(), is(1));
    }

    @Test
    public void show_ReturnsTrue() {
        assertThat(cell.getShow(), is(1));
    }

    @Test
    public void required_ReturnsTrue() {
        assertThat(cell.isRequired(), is(true));
    }

    @Test
    public void getEditTextValue_ReturnsTrue() {
        assertThat(cell.getEditTextValue(), is("string"));
    }

    @Test
    public void getEditTextValue_ReturnsFalse() {
        assertEquals(cell.getEditTextValue() == "", false);
    }
}