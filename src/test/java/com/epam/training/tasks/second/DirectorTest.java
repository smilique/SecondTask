package com.epam.training.tasks.second;

import com.epam.training.tasks.second.data.DataReader;
import com.epam.training.tasks.second.data.DataReaderException;
import com.epam.training.tasks.second.logic.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


public class DirectorTest {

    private final String GIVEN = "one two three four five six";
    private final String EXPECTED_SYMBOL = "one two thr#e fou# fiv# six";
    private final String EXPECTED_SUBSTRING = "one two three mississippi mississippi six";


    @Test
    public void testDirectorShouldReturnFormattedTextWhenSymbolReplaceStringProcessingRequested() throws DataReaderException {

        //given
        TextProcessorFactory textProcessorFactory = Mockito.mock(TextProcessorFactory.class);
        when(textProcessorFactory.create(any())).thenReturn(new StringBasedTextProcessor());

        TextProcessor textProcessor = textProcessorFactory.create(null);

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readData(anyString())).thenReturn(GIVEN);

        String inputData = dataReader.readData("");

        Director director = new Director(dataReader, textProcessorFactory);

        //when
        String actual = director.processText(inputData,4,'#',textProcessor);

        //then
        Assert.assertEquals(EXPECTED_SYMBOL, actual);
    }

    @Test
    public void testDirectorShouldReturnFormattedTextWhenSymbolReplaceSymbolProcessingRequested() throws DataReaderException{

        //given
        TextProcessorFactory textProcessorFactory = Mockito.mock(TextProcessorFactory.class);
        when(textProcessorFactory.create(any())).thenReturn(new SymbolBasedTextProcessor());

        TextProcessor textProcessor = textProcessorFactory.create(null);

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readData(anyString())).thenReturn(GIVEN);

        String inputData = dataReader.readData("");
        Director director = new Director(dataReader, textProcessorFactory);

        //when
        String actual = director.processText(inputData,4,'#',textProcessor);

        //then
        Assert.assertEquals(EXPECTED_SYMBOL, actual);
    }

    @Test
    public void testDirectorShouldReturnFormattedTextWhenSymbolReplaceRegexpProcessingRequested() throws DataReaderException{

        //given
        TextProcessorFactory textProcessorFactory = Mockito.mock(TextProcessorFactory.class);
        when(textProcessorFactory.create(any())).thenReturn(new RegexpBasedTextProcessor());

        TextProcessor textProcessor = textProcessorFactory.create(null);

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readData(anyString())).thenReturn(GIVEN);

        String inputData = dataReader.readData("");
        Director director = new Director(dataReader, textProcessorFactory);

        //when
        String actual = director.processText(inputData,4,'#',textProcessor);

        //then
        Assert.assertEquals(EXPECTED_SYMBOL, actual);
    }

    @Test
    public void testDirectorShouldReturnFormattedTextWhenSubstringReplaceStringProcessingRequested() throws DataReaderException {

        //given
        TextProcessorFactory textProcessorFactory = Mockito.mock(TextProcessorFactory.class);
        when(textProcessorFactory.create(any())).thenReturn(new StringBasedTextProcessor());

        TextProcessor textProcessor = textProcessorFactory.create(null);

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readData(anyString())).thenReturn(GIVEN);

        String inputData = dataReader.readData("");

        Director director = new Director(dataReader, textProcessorFactory);

        //when
        String actual = director.processText(inputData,4,"mississippi",textProcessor);

        //then
        Assert.assertEquals(EXPECTED_SUBSTRING, actual);
    }

    @Test
    public void testDirectorShouldReturnFormattedTextWhenSubstringReplaceSymbolProcessingRequested() throws DataReaderException{

        //given
        TextProcessorFactory textProcessorFactory = Mockito.mock(TextProcessorFactory.class);
        when(textProcessorFactory.create(any())).thenReturn(new SymbolBasedTextProcessor());

        TextProcessor textProcessor = textProcessorFactory.create(null);

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readData(anyString())).thenReturn(GIVEN);

        String inputData = dataReader.readData("");
        Director director = new Director(dataReader, textProcessorFactory);

        //when
        String actual = director.processText(inputData,4,"mississippi",textProcessor);

        //then
        Assert.assertEquals(EXPECTED_SUBSTRING, actual);
    }

    @Test
    public void testDirectorShouldReturnFormattedTextWhenSubstringReplaceRegexpProcessingRequested() throws DataReaderException{

        //given
        TextProcessorFactory textProcessorFactory = Mockito.mock(TextProcessorFactory.class);
        when(textProcessorFactory.create(any())).thenReturn(new RegexpBasedTextProcessor());

        TextProcessor textProcessor = textProcessorFactory.create(null);

        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readData(anyString())).thenReturn(GIVEN);

        String inputData = dataReader.readData("");
        Director director = new Director(dataReader, textProcessorFactory);

        //when
        String actual = director.processText(inputData,4,"mississippi",textProcessor);

        //then
        Assert.assertEquals(EXPECTED_SUBSTRING, actual);
    }
}