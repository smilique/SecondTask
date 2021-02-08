package com.epam.training.tasks.second.logic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegexpBasedTextProcessorTest {

    private final RegexpBasedTextProcessor textProcessor = new RegexpBasedTextProcessor();
    private final String DATA = "cow snow ok determine what a weather sup";
    private final String EXPECTED_SYMBOL = "co$ sn$w ok de$ermine wh$t a we$ther su$";
    private final String EXPECTED_SUBSTRING = "former snow ok determine what a weather former";

    @Test
    public void replaceSymbol() {

        //given

        //when
        String actual = textProcessor.replaceSubstring(DATA,3,"former");

        //then
        Assert.assertEquals(EXPECTED_SUBSTRING,actual);

    }

    @Test
    public void replaceSubstring() {

        //given

        //when
        String actual = textProcessor.replaceSymbol(DATA,3,'$');

        //then
        Assert.assertEquals(EXPECTED_SYMBOL,actual);

    }
}