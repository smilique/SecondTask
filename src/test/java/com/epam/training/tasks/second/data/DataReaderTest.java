package com.epam.training.tasks.second.data;

import org.junit.Assert;
import org.junit.Test;


public class DataReaderTest {

    @Test
    public void testFileDataReaderShouldReadFileDataFromTest() throws DataReaderException {

        //given
        String expected = "451854 edge stream luck luke p!rate   invite skill #@&> nowhe><&re poin^t";
        DataReader reader = new DataReader();

        //when
        String actual = reader.readData("./src/test/resources/testinput.txt");

        //then
        Assert.assertEquals(expected,actual);

    }


}
