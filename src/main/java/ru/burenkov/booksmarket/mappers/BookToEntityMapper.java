package ru.burenkov.booksmarket.mappers;

import org.mapstruct.Mapper;
import ru.burenkov.booksmarket.entity.BookEntity;
import ru.burenkov.booksmarket.model.Book;

@Mapper
public interface BookToEntityMapper {
BookEntity bookToBookEntity(Book book);
Book bookEntityToBook(BookEntity bookEntity);
}
