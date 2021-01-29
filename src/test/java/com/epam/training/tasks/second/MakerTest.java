package com.epam.training.tasks.second;


import com.epam.training.tasks.second.data.DataReaderException;
import org.junit.Assert;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static com.epam.training.tasks.second.data.ProcessorType.*;

public class MakerTest {

    @Test
    public void testMakerShouldReturnArrayListByThirdProcessorWithFileReader() throws DataReaderException {
        //given
        Maker maker = new Maker();
        List<String> expected = Arrays.asList("451854 edge stream", "luck coma p!rate   invite", "skill coma nowhe><&re poin^t");

        //when
        List<String> actual = maker.makeList("./src/test/resources/testinput.txt",3,"coma",STRING);

        //then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testMakerShouldReturnArrayListByThirdProcessorWithConsoleReader() throws DataReaderException {
        //given
        Maker maker = new Maker();
        List<String> expected = Arrays.asList("451854 edge stream", "luck coma p!rate   invite", "skill coma nowhe><&re poin^t");

        //when
        List<String> actual = maker.makeList(3,"coma",STRING);

        //then
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void testMakerShouldReturnArrayListByFirstProcessorWithFileReader() throws DataReaderException {
        //given
        Maker maker = new Maker();
        List<String> expected = Arrays.asList("45#854 ed#e st#eam", "lu#k lu#e p!#ate   in#ite", "sk#ll #@#> no#he><&re po#n^t");

        //when
        List<String> actual = maker.makeList("./src/test/resources/testinput.txt",3,'#',STRING);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMakerShouldReturnArrayListByFirstProcessorWithConsoleReader() throws DataReaderException {
        //given
        Maker maker = new Maker();
        List<String> expected = Arrays.asList("45#854 ed#e st#eam", "lu#k lu#e p!#ate   in#ite", "sk#ll #@#> no#he><&re po#n^t");

        //when
        List<String> actual = maker.makeList(3,'#',STRING);

        //then
        Assert.assertEquals(expected, actual);
    }

}
