package com.epam.training.tasks.second.data;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DataReader {

    private final static Logger LOGGER = Logger.getLogger(DataReader.class);

    public String readData(String path) throws DataReaderException{

        LOGGER.info("FileDataReader reads from " + path);

        BufferedReader reader = null;

        try  {

            reader = new BufferedReader(new FileReader(path));
            String data = null;

            if (reader.ready()) {
                data = reader.readLine();
            }

            LOGGER.info("FileDataReader successful read " + path);

            return data;

        } catch (IOException e) {
            LOGGER.error(e.getMessage(),e);
            throw new DataReaderException(e.getMessage(),e);
        }

        finally {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException e) {
                        LOGGER.error(e.getMessage(),e);
                    }
                }

        }


    }
}
