package com.epam.training.tasks.second.logic;

import com.epam.training.tasks.second.data.ProcessorType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThirdOptionProcessor{

    private static final Logger LOGGER = Logger.getLogger(FirstOptionProcessor.class);

    // В тексте слова заданной длины заменить указанной подстрокой,
    // длина которой может не совпадать с длиной слова.
    //with String
    //with Symbol String
    //with regular expressions

    public List<String> process(List<String> data, int length, String substring, ProcessorType method) {

        List<String> result = new ArrayList<>();

        switch (method) {
            case STRING : {

                LOGGER.info("Processing by string started.");

                result = processString(data, length, substring);
                return result;
            }
            case SYMBOL : {

                LOGGER.info("Processing by char started.");

                result = processSymbol(data, length, substring);
                return result;
            }
            case REGULAR : {

                LOGGER.info("Processing by regexp started.");

                result = processRegular(data, length, substring);
                return result;
            }
            default: {

                return null;
            }


        }

    }

    private List<String> processString(List<String> data, int length, String substring) {

        List<String> result = new ArrayList<>();

        for (String element : data) {

            String changedElement = "";

            for (String word : element.split(" ",0)) {

                if (word.length() == length) {
                    changedElement += " " + substring;
                } else {
                    changedElement += " " + word;
                }
            }
            result.add(changedElement.trim());
        }
        return result;

    }

    private List<String> processRegular(List<String> data, int length, String substring) {

        List<String> result = new ArrayList<>();

        for (String element : data) {
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(element);

            String line = "";

            while (matcher.find()) {
                StringBuilder builder = new StringBuilder();
                builder.append(matcher.group());

                if (builder.length() == length) {
                    line += " " + substring;
                } else
                {
                    line += " " + builder.toString();
                }

            }
            result.add(line.trim());
        }
        return result;
    }

    private List<String> processSymbol(List<String> data, int length, String substring) {

        List<String> result = new ArrayList<>();

        for (String element : data) {

            String changedElement = "";
            char[] chars = element.toCharArray();
            String word = "";
            for (char aChar : chars) {
                if (aChar != ' ') {
                    word += aChar;
                } else {
                    String trimmedWord = word.trim();
                    if (trimmedWord.length() == length) {
                        changedElement += " " + substring;
                    } else {
                        changedElement += " " + word;
                    }
                    word = "";
                }
            }
            if (word.length() == length) {
                changedElement += " " + substring;
            } else {
                changedElement += " " + word;
            }

            result.add(changedElement.trim());
        }
        return result;

    }

}
