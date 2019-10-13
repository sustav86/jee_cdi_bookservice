package com.sustav.book.service;

import com.sustav.book.entity.Book;
import com.sustav.book.intercepter.Loggable;
import com.sustav.book.number_generator.NumberGenerator;
import com.sustav.book.qualifiers.Added;
import com.sustav.book.qualifiers.ThirteenDigits;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.logging.Logger;

@Loggable
public class BookService {
    @Inject
    private Logger logger;
    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;
    @Inject @Added
    private Event<Book> bookAddedEvent;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        bookAddedEvent.fire(book);
        logger.info("Return book");
        return book;
    }
}
