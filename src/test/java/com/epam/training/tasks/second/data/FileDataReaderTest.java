package com.epam.training.tasks.second.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {

    private DataReader reader = new FileDataReader();

    @Test
    public void testFileDataReaderShouldReadFileWithSingleLine() throws DataReaderException {
        //given
        List<String> expected = Arrays.asList("451854 edge stream");

        //when
        List<String> actual = reader.readData("./src/test/resources/testlineinput.txt");

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFileDataReaderShouldReadFileDataFromMain() throws DataReaderException {

        //given
        List<String> expected = Arrays.asList("flow sky bed tier","dry","socks of new america","no more by sample");

        //when
        List<String> actual = reader.readData();

        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testFileDataReaderShouldReadFileDataFromTest() throws DataReaderException {

        //given
        List<String> expected = Arrays.asList("451854 edge stream", "luck luke p!rate   invite", "skill #@&> nowhe><&re poin^t");

        //when
        List<String> actual = reader.readData("./src/test/resources/testinput.txt");

        //then
        Assert.assertEquals(expected,actual);

    }


}
