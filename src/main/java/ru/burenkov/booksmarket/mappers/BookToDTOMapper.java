package ru.burenkov.booksmarket.mappers;

import org.mapstruct.Mapper;
import ru.burenkov.booksmarket.DTO.BookRequest;
import ru.burenkov.booksmarket.model.Book;

@Mapper
public interface BookToDTOMapper {
    Book AddBookRequestToBook(BookRequest bookRequest);
    Book EditBookRequestToBook(Long id,BookRequest bookRequest);
    Book DeleteBookRequestToBook(Long id);
}
