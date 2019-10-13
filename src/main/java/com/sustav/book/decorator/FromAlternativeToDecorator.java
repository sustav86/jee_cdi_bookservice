package com.sustav.book.decorator;

import com.sustav.book.number_generator.NumberGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * @author Anton Sustavov
 * @since 2019/10/13
 */
@Decorator
public class FromAlternativeToDecorator implements NumberGenerator {
    @Inject
    private Logger logger;
    @Inject @Delegate @Any
    private NumberGenerator numberGenerator;
    @Override
    public String generateNumber() {
        String number = numberGenerator.generateNumber();
        logger.info("START DECORATOR");
        return number + " fuck";
    }
}
