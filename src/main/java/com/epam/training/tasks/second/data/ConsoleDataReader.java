package com.epam.training.tasks.second.data;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleDataReader implements DataReader {

    private final static Logger LOGGER = Logger.getLogger(ConsoleDataReader.class);

    @Override
    public List<String> readData() {

        LOGGER.info("ConsoleDataReader started");

        List<String> data = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = bufferedReader.readLine();
            while(line.length() > 0) {
                data.add(line);
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            LOGGER.error(e.getMessage(),e);
        }

        LOGGER.info("ConsoleDataReader finished");
        return data;
    }

    @Override
    public List<String> readData(String path) {

        return readData();

    }
}
