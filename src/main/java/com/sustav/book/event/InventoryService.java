package com.sustav.book.event;

import com.sustav.book.entity.Book;
import com.sustav.book.qualifiers.Added;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Anton Sustavov
 * @since 2019/10/13
 */
public class InventoryService {
    @Inject
    private Logger logger;
    List<Book> inventory = new ArrayList<>();
    public void addBook(@Observes @Added Book book) {
        logger.info("Adding book " + book.getTitle() + "to inventory");
        inventory.add(book);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
