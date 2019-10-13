package com.sustav.book.number_generator;

import com.sustav.book.intercepter.Loggable;
import com.sustav.book.qualifiers.ThirteenDigits;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@ThirteenDigits
@Alternative
public class MockGenerator implements NumberGenerator {
    @Inject
    private Logger logger;
    @Override
    @Loggable
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован Mock : " + mock);
        return mock;
    }
}
