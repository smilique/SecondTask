package com.epam.training.tasks.second.logic;

import org.junit.Assert;
import org.junit.Test;

import static com.epam.training.tasks.second.logic.ProcessorType.*;

public class TextProcessorFactoryTest {

    @Test
    public void testTextProcessorFactoryShouldReturnSymbolBasedTextProcessorWhenSymbolBasedProcessorRequested() {

        //given
        TextProcessorFactory factory = new TextProcessorFactory();
        Class expected = SymbolBasedTextProcessor.class;
        TextProcessor processor = factory.create(SYMBOL);

        //when
        Class actual = processor.getClass();

        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testTextProcessorFactoryShouldReturnStringBasedTextProcessorWhenStringBasedProcessorRequested() {

        //given
        TextProcessorFactory factory = new TextProcessorFactory();
        Class expected = StringBasedTextProcessor.class;
        TextProcessor processor = factory.create(STRING);

        //when
        Class actual = processor.getClass();

        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testTextProcessorFactoryShouldReturnRegexpBasedTextProcessorWhenRegexpBasedProcessorRequested() {

        //given
        TextProcessorFactory factory = new TextProcessorFactory();
        Class expected = RegexpBasedTextProcessor.class;
        TextProcessor processor = factory.create(REGULAR);

        //when
        Class actual = processor.getClass();

        //then
        Assert.assertEquals(expected,actual);

    }

}