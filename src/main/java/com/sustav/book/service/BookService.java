package com.sustav.book.service;

import com.sustav.book.entity.Book;
import com.sustav.book.intercepter.Loggable;
import com.sustav.book.number_generator.NumberGenerator;
import com.sustav.book.qualifiers.ThirteenDigits;

import javax.inject.Inject;

@Loggable
public class BookService {
    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
