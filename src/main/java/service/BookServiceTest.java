package service;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookServiceTest implements BookServiceInt {
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return Stream.of(new Book(22L, "fakeBook", 2041)).collect(Collectors.toList());
    }
}
