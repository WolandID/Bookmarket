package ru.burenkov.booksmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.burenkov.booksmarket.DAO.BookRepository;
import ru.burenkov.booksmarket.entity.BookEntity;
import ru.burenkov.booksmarket.model.Book;
import ru.burenkov.booksmarket.model.BookToEntityMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService{
    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;
    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow();
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (BookEntity bookEntity:iterable
             ) {
            books.add(mapper.bookEntityToBook(bookEntity));
            
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);

    }

}
