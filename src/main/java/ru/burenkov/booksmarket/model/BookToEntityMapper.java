package ru.burenkov.booksmarket.model;

import org.mapstruct.Mapper;
import ru.burenkov.booksmarket.entity.BookEntity;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
BookEntity bookToBookEntity(Book book);
Book bookEntityToBook(BookEntity bookEntity);
}
