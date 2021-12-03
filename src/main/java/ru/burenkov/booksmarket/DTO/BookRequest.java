package ru.burenkov.booksmarket.DTO;

import lombok.Data;

@Data
public class BookRequest {
String author;
String title;
Double price;
}
