package ru.burenkov.booksmarket.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.burenkov.booksmarket.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity,Long> {
}
