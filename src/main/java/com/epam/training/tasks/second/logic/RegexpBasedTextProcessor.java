package com.epam.training.tasks.second.logic;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpBasedTextProcessor implements TextProcessor {

    private final static Logger LOGGER = Logger.getLogger(RegexpBasedTextProcessor.class);
    private final String WORDS_PATTERN = "\\S+";

    @Override
    public String replaceSymbol(String text, int symbolIndex, char newSymbol) {

        LOGGER.info("Regexp based replaceSymbol started.");

        Pattern pattern = Pattern.compile(WORDS_PATTERN);
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {

            StringBuilder builder = new StringBuilder();
            builder.append(matcher.group());

            if (builder.length() >= symbolIndex) {

                builder.setCharAt(symbolIndex-1, newSymbol);

            }
            result.append(" ");
            result.append(builder);
        }
            result.deleteCharAt(0);

        return result.toString();
    }

    @Override
    public String replaceSubstring(String text, int length, String substring) {

        LOGGER.info("Regexp based replaceSubstring started.");

        Pattern pattern = Pattern.compile(WORDS_PATTERN);
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            StringBuilder builder = new StringBuilder();
            builder.append(matcher.group());

            if (builder.length() == length) {
                result.append(" ");
                result.append(substring);
            } else
            {
                result.append(" ");
                result.append(builder);
            }
        }

        result.deleteCharAt(0);

        return result.toString();
    }
}
