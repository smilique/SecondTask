package com.epam.training.tasks.second;

import com.epam.training.tasks.second.data.DataReader;
import com.epam.training.tasks.second.data.DataReaderException;
import com.epam.training.tasks.second.logic.TextProcessor;
import com.epam.training.tasks.second.logic.TextProcessorFactory;
import org.apache.log4j.Logger;

public class Director {

    private final DataReader dataReader;
    private final TextProcessorFactory textProcessorFactory;

    public Director(DataReader dataReader, TextProcessorFactory textProcessorFactory) {
        this.dataReader = dataReader;
        this.textProcessorFactory = textProcessorFactory;
    }

    private static final Logger LOGGER = Logger.getLogger(Director.class);


    public String processText(String filename, int symbolIndex, char newSymbol, TextProcessor textProcessor) throws DataReaderException {

        LOGGER.info("Formatting text from \"" + filename + "\" with "
                + textProcessor.getClass());

        String fileData = dataReader.readData(filename);

        return textProcessor.replaceSymbol(fileData,symbolIndex,newSymbol);
    }

    public String processText(String filename, int symbolIndex, String substring, TextProcessor textProcessor) throws DataReaderException {

        LOGGER.info("Formatting text from \"" + filename + "\" with "
                + textProcessor.getClass());

        String fileData = dataReader.readData(filename);

        return textProcessor.replaceSubstring(fileData,symbolIndex,substring);
    }







}
