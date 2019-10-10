package com.sustav.book.number_generator;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.sustav.book.intercepter.Loggable;
import com.sustav.book.qualifiers.ThirteenDigits;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;
    @Override
    @Loggable
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + isbn);
        return isbn;
    }
}
