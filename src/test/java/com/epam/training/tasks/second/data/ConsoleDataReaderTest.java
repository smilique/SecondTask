package com.epam.training.tasks.second.data;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ConsoleDataReaderTest {

    private final List<String> TEST_DATA = Arrays.asList("true false !k112eeyy", "34ff !@ dfhuh", "salt print");
    private List<String> expected = Arrays.asList("true false !k112eeyy", "34ff !@ dfhuh", "salt print");

    @Test
    public void testConsoleReaderShouldReadData() throws DataReaderException{
        //given
        DataReader reader = Mockito.mock(ConsoleDataReader.class);
        when(reader.readData()).thenReturn(TEST_DATA);

        //when
        List<String> actual = reader.readData();

        //then
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void testConsoleReaderShouldReadDataAndIgnorePathSpecified() throws DataReaderException{
        //given
        DataReader reader = Mockito.mock(ConsoleDataReader.class);
        when(reader.readData(anyString())).thenReturn(TEST_DATA);

        //when
        List<String> actual = reader.readData("./etc");

        //then
        Assert.assertEquals(actual,expected);
    }

}
