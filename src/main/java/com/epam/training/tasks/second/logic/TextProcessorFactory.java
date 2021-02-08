package com.epam.training.tasks.second.logic;

import org.apache.log4j.Logger;

public class TextProcessorFactory {

    private final static Logger LOGGER = Logger.getLogger(TextProcessorFactory.class);

    public TextProcessor create(ProcessorType type) {

        LOGGER.info("TextProcessor create started with " + type + " parameter");

        TextProcessor textProcessor = null;
        switch (type) {
            case STRING: {
                textProcessor = new StringBasedTextProcessor();
                break;
            }
            case SYMBOL: {
                textProcessor = new SymbolBasedTextProcessor();
                break;
            }
            case REGULAR: {
                textProcessor = new RegexpBasedTextProcessor();
                break;
            }
            default: {
                break;
            }
        }
        return textProcessor;

    }
}
