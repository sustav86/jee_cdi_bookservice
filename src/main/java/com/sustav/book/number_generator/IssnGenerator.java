package com.sustav.book.number_generator;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.sustav.book.intercepter.Loggable;
import com.sustav.book.qualifiers.EightDigits;

@EightDigits
public class IssnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;
    @Override
    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + issn);
        return issn;
    }
}
