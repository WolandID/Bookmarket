package ru.burenkov.booksmarket.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.burenkov.booksmarket.entity.BookEntity;
import ru.burenkov.booksmarket.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity,Long> {
    public List<BookEntity> findAllByAuthorContaining(String author);
}
