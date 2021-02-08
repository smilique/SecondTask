package com.epam.training.tasks.second.logic;

import org.apache.log4j.Logger;

public class StringBasedTextProcessor implements TextProcessor {

    private final static Logger LOGGER = Logger.getLogger(StringBasedTextProcessor.class);

    @Override
    public String replaceSymbol(String text, int symbolIndex, char newSymbol) {

        LOGGER.info("String based replaceSymbol started.");

        String changedElement = "";

        for (String word : text.split(" ",0)) {
            if (word.length() < symbolIndex) {
                changedElement += " " + word;
            } else {
                String firstSubstring = word.substring(0,symbolIndex-1);
                String secondSubstring = "";
                if (word.length() != symbolIndex) {
                    secondSubstring = word.substring(symbolIndex);
                }
                changedElement += " " + firstSubstring + newSymbol + secondSubstring;
            }
        }

        return changedElement.trim();
    }

    @Override
    public String replaceSubstring(String text, int length, String substring) {

        LOGGER.info("String based replaceSubstring started.");

        StringBuilder stringBuilder = new StringBuilder();

        for (String word : text.split(" ",0)) {

            if (word.length() == length) {
                stringBuilder.append(" ");
                stringBuilder.append(substring);;
            } else {
                stringBuilder.append(" ");
                stringBuilder.append(word);
            }
        }

        String result = stringBuilder.toString();

        return result.trim();
    }
}
