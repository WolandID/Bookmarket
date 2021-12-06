package ru.burenkov.booksmarket.service;

import ru.burenkov.booksmarket.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    List<Book> getAllBooks();
    void addBook(Book book);
    void editBook(Book book);
    void deleteBook(Book book);
}
