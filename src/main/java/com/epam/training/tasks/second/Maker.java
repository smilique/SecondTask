package com.epam.training.tasks.second;

import com.epam.training.tasks.second.data.*;
import com.epam.training.tasks.second.logic.FirstOptionProcessor;
import com.epam.training.tasks.second.logic.ThirdOptionProcessor;
import org.apache.log4j.Logger;

import java.util.List;

public class Maker {

    private static final Logger LOGGER = Logger.getLogger(Maker.class);

    public List<String> makeList(int letterNumber, char symbol, ProcessorType method ) throws DataReaderException {

        LOGGER.info("makeList from console started (First)");

        DataReader reader = new ConsoleDataReader();
        FirstOptionProcessor processor = new FirstOptionProcessor();
        List<String> result = processor.process(reader.readData(), letterNumber,symbol,method);

        return result;
    }

    public List<String> makeList(String path, int letterNumber, char symbol, ProcessorType method) throws DataReaderException {

        LOGGER.info("makeList from file started (First)");

        DataReader reader = new FileDataReader();
        FirstOptionProcessor processor = new FirstOptionProcessor();
        List<String> result = processor.process(reader.readData(path), letterNumber,symbol,method);

        return result;
    }
    public List<String> makeList(int length, String substring, ProcessorType method ) throws DataReaderException {

        LOGGER.info("makeList from console started (Third)");

        DataReader reader = new ConsoleDataReader();
        ThirdOptionProcessor processor = new ThirdOptionProcessor();
        List<String> result = processor.process(reader.readData(),length,substring,method);

        return result;
    }

    public List<String> makeList(String path, int length, String substring, ProcessorType method) throws DataReaderException {

        LOGGER.info("makeList from file started (Third)");

        DataReader reader = new FileDataReader();
        ThirdOptionProcessor processor = new ThirdOptionProcessor();
        List<String> result = processor.process(reader.readData(path),length,substring,method);

        return result;
    }


}
