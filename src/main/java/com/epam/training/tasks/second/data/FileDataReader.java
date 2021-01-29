package com.epam.training.tasks.second.data;

import com.epam.training.tasks.second.Main;
import org.apache.log4j.Logger;

import java.util.List;


public class FileDataReader implements DataReader {

    private final String PATH = "./src/main/resources/input.txt";
    private final static Logger LOGGER = Logger.getLogger(FileDataReader.class);
    private final FileDataReaderProcessor processor = new FileDataReaderProcessor();

    @Override
    public List<String> readData() {
        LOGGER.info("FileDataReader reads from ./src/main/resources/input.txt");

        List<String> data = processor.read(PATH);

        LOGGER.info("FileDataReader successful read ./src/main/resources/input.txt");

        return data;
    }

    public List<String> readData(String path) {
        LOGGER.info("FileDataReader reads from " + path);

        List<String> data = processor.read(path);

        LOGGER.info("FileDataReader successful read " + path);

        return data;
    }
}
