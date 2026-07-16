package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("Managing books in BookService...");
        if (bookRepository != null) {
            bookRepository.display();
        } else {
            System.out.println("BookRepository is not injected!");
        }
    }
}
