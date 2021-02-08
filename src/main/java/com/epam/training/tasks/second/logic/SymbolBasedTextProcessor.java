package com.epam.training.tasks.second.logic;

import org.apache.log4j.Logger;

public class SymbolBasedTextProcessor implements TextProcessor {

    private final static Logger LOGGER = Logger.getLogger(SymbolBasedTextProcessor.class);

    @Override
    public String replaceSymbol(String text, int symbolIndex, char newSymbol) {

        LOGGER.info("Symbol based replaceSymbol started.");

        String result = "";
        String word = "";
        int counter = 1;
        char[] chars = text.toCharArray();

        for (char aChar : chars) {
            if (aChar == ' ') {

                counter = 1;
                result += " " + word;
                word = "";

            } else {
                if (counter == symbolIndex) {
                    word += newSymbol;
                } else {
                    word += aChar;
                }
                counter++;
            }
        }

        result += " " + word;

        return result.trim();
    }

    @Override
    public String replaceSubstring(String text, int length, String substring) {

        LOGGER.info("Symbol based replaceSubstring started.");

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = text.toCharArray();
        String word = "";

        for (char aChar : chars) {
            if (aChar != ' ') {
                word += aChar;
            } else {
                String trimmedWord = word.trim();
                if (trimmedWord.length() == length) {
                    stringBuilder.append(" ");
                    stringBuilder.append(substring);
                } else {
                    stringBuilder.append(" ");
                    stringBuilder.append(word);
                }
                word = "";
            }
        }
        if (word.length() == length) {
            stringBuilder.append(" ");
            stringBuilder.append(substring);
        } else {
            stringBuilder.append(" ");
            stringBuilder.append(word);
        }

        String result = stringBuilder.toString();

        return result.trim();
    }
}
