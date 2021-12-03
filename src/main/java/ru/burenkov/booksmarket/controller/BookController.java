package ru.burenkov.booksmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.burenkov.booksmarket.DTO.BookRequest;
import ru.burenkov.booksmarket.model.Book;
import ru.burenkov.booksmarket.model.BookToDTOMapper;
import ru.burenkov.booksmarket.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
private final BookService bookService;
private final BookToDTOMapper mapper;

@GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
    return bookService.getBookById(id);
    }
@GetMapping
    public List<Book> getAllBooks(){
    return bookService.getAllBooks();
}

@PostMapping
    public void addBook(@RequestBody BookRequest request){
    bookService.addBook(mapper.AddBookRequestToBook(request));

}


}
