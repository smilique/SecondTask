package com.epam.training.tasks.second.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.training.tasks.second.data.ProcessorType.*;

public class TestFirstOptionProcessor {

    private final List<String> DATA = Arrays.asList("cow snow ok determine","what a weather");
    private final FirstOptionProcessor PROCESSOR = new FirstOptionProcessor();
    private final List<String> EXPECTED = Arrays.asList("co$ sn$w ok de$ermine","wh$t a we$ther");

    @Test
    public void testFirstOptionProcessorShouldChangeSymbolWithStringProcessor() {
        //given

        //when
        List<String> actual = PROCESSOR.process(DATA,3,'$', STRING);
        //then
        Assert.assertEquals(EXPECTED,actual);
    }

    @Test
    public void testFirstOptionProcessorShouldChangeSymbolWithCharProcessor() {
        //given


        //when
        List<String> actual = PROCESSOR.process(DATA,3,'$', SYMBOL);
        //then
        Assert.assertEquals(EXPECTED,actual);
    }

    @Test
    public void testFirstOptionProcessorShouldChangeSymbolWithRegularProcessor() {
        //given

        //when
        List<String> actual = PROCESSOR.process(DATA,3,'$', REGULAR);
        //then
        Assert.assertEquals(EXPECTED,actual);
    }
}
