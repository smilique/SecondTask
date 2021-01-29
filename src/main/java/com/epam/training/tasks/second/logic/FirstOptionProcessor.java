package com.epam.training.tasks.second.logic;

import com.epam.training.tasks.second.data.ProcessorType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstOptionProcessor{

    private static final Logger LOGGER = Logger.getLogger(FirstOptionProcessor.class);

    // В каждом слове k-ю букву заменить заданным символом.
    //   Если k больше длины слова, корректировку не выполнять.
    //with String
    //with Symbol String
    //with regular expressions

    public List<String> process(List<String> data, int letterNumber, char symbol, ProcessorType method) {

        List<String> result;

        switch (method) {

            case STRING : {

                LOGGER.info("Processing by string started.");

                result = processString(data,letterNumber,symbol);
                return result;
            }

            case SYMBOL: {

                LOGGER.info("Processing by char started.");

                result = processSymbol(data,letterNumber,symbol);
                return result;
            }

            case REGULAR : {

                LOGGER.info("Processing by regexp started.");

                result = processRegular(data,letterNumber,symbol);
                return result;
            }

            default: {
                return null;
            }

        }


    }

    private List<String> processString(List<String> data, int letterNumber, char symbol) {

        List<String> result = new ArrayList<>();

        for (String element : data) {
            String changedElement = "";
            for (String word : element.split(" ",0)) {
                if (word.length() < letterNumber) {
                    changedElement += " " + word;
                } else {
                    String firstSubstring = word.substring(0,letterNumber-1);
                    String secondSubstring = "";
                    if (word.length() != letterNumber) {
                        secondSubstring = word.substring(letterNumber);
                    }
                    changedElement += " " + firstSubstring + symbol + secondSubstring;

                }
            }

            result.add(changedElement.trim());
        }
        return result;

    }

    private List<String> processRegular(List<String> data, int letterNumber, char symbol) {

        List<String> result = new ArrayList<>();


        for (String element : data) {
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(element);

            String line = "";
            while (matcher.find()) {
                StringBuilder builder = new StringBuilder();
                builder.append(matcher.group());

                if (builder.length() >= letterNumber) {
                    builder.setCharAt(letterNumber-1, symbol);
                }
                line += " " + builder.toString();
            }
            result.add(line.trim());
        }
        return result;
    }

    private List<String> processSymbol(List<String> data, int letterNumber, char symbol) {

        List<String> result = new ArrayList<>();

        for (String element : data) {

            String changedElement = "";
            char[] chars = element.toCharArray();
            String word = "";
            int counter = 1;
            for (char aChar : chars) {
                if (aChar == ' ') {
                    counter = 1;
                    changedElement += " " + word;
                    word = "";
                } else {
                    if (counter == letterNumber) {
                        word += symbol;
                    } else {
                        word += aChar;
                    }
                    counter++;
                }
            }
            changedElement += " " + word;

            result.add(changedElement.trim());
        }
        return result;

    }

}
