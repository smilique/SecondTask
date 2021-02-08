package com.epam.training.tasks.second.logic;

public interface TextProcessor {

    String replaceSymbol (String text, int index, char newSymbol);
    String replaceSubstring (String text, int wordLength, String substring);

}
