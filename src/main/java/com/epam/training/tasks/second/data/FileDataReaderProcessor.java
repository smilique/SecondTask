package com.epam.training.tasks.second.data;

import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReaderProcessor {

    public static final Logger LOGGER = Logger.getLogger(FileDataReaderProcessor.class);
    private final char END_OF_LINE = '\r';

    public List<String> read(String path) {

        List<String> data = new ArrayList<>();

        try (FileReader fileReader = new FileReader(path)) {

            StringBuffer buffer = new StringBuffer();

            while (fileReader.ready()) {
                char element = (char) fileReader.read();
                if (element == END_OF_LINE) {
                    data.add(buffer.toString());
                    buffer = new StringBuffer();
                    fileReader.read();
                } else {
                    buffer.append(element);
                }
            }
            if (buffer.length() > 0) {
                data.add(buffer.toString());
            }

        } catch (IOException e) {

            LOGGER.error(e.getMessage(),e);
        }

        return data;
    }

}
