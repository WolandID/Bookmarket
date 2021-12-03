package ru.burenkov.booksmarket.model;

import org.mapstruct.Mapper;
import ru.burenkov.booksmarket.DTO.BookRequest;

@Mapper(componentModel = "spring")
public interface BookToDTOMapper {
    Book AddBookRequestToBook(BookRequest bookRequest);
}
