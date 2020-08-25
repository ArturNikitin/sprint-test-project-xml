package dao;

import entity.Author;
import entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthor(Author author);
}
