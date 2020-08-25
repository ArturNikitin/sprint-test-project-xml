package service;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Author;
import entity.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class BookService implements BookServiceInt {

    private BookDao bookDao;

    public List<Book> getAllBooks() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EntityManagerFactory factory = (EntityManagerFactory) context.getBean("myEmf");
        EntityManager manager = factory.createEntityManager();
        bookDao = new BookDaoImpl(manager);
        return bookDao.getAllBooks();
    }


}
