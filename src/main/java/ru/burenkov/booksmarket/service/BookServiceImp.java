package ru.burenkov.booksmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.burenkov.booksmarket.DAO.BookRepository;
import ru.burenkov.booksmarket.entity.BookEntity;
import ru.burenkov.booksmarket.exception.BookNotFoundException;
import ru.burenkov.booksmarket.model.Book;
import ru.burenkov.booksmarket.mappers.BookToEntityMapper;

import javax.print.StreamPrintService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService{

    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found id =" + id));
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(),false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);

    }

    @Override
    public void editBook(Book book) {
        if(!bookRepository.existsById(book.getId()))
        {throw new BookNotFoundException("Book not found id = "+book.getId());}
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    @Override
    public void deleteBook(Book book) {
        if(!bookRepository.existsById(book.getId()))
        {throw new BookNotFoundException("Book not found id = "+book.getId());}
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.delete(bookEntity);
    }

    @Override
    public List<Book> findAllByAuthor(String author) {
        Iterable<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);
        return StreamSupport.stream(iterable.spliterator(),false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

}
