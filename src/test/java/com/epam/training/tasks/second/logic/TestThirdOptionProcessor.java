package com.epam.training.tasks.second.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.training.tasks.second.data.ProcessorType.*;


public class TestThirdOptionProcessor {

    private final ThirdOptionProcessor PROCESSOR = new ThirdOptionProcessor();
    private final List<String> DATA = Arrays.asList("cow snow ok determine","what a weather low");
    private final List<String> EXPECTED = Arrays.asList("former snow ok determine","what a weather former");

    @Test
    public void testThirdOptionProcessorShouldChangeSubstringWithStringProcessor() {
        //given

        //when
        List<String> actual = PROCESSOR.process(DATA,3,"former", STRING);

        //then
        Assert.assertEquals(EXPECTED,actual);

    }

    @Test
    public void testThirdOptionProcessorShouldChangeSubstringWithSymbolProcessor() {
        //given

        //when
        List<String> actual = PROCESSOR.process(DATA,3,"former", SYMBOL);

        //then
        Assert.assertEquals(EXPECTED,actual);

    }
    @Test
    public void testThirdOptionProcessorShouldChangeSubstringWithRegularProcessor() {
        //given

        //when
        List<String> actual = PROCESSOR.process(DATA,3,"former",REGULAR);

        //then
        Assert.assertEquals(EXPECTED,actual);

    }
}
