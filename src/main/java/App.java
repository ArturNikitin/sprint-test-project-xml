import contexttest.User;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Author;
import entity.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("userBean");
        System.out.println(user.getName());

        BookDaoImpl bookDao = (BookDaoImpl) context.getBean("bookDao");

       /* EntityManagerFactory factory = Persistence.createEntityManagerFactory("prodUnit");*/
        EntityManagerFactory factory = (EntityManagerFactory) context.getBean("myEmf");
        EntityManager manager = factory.createEntityManager();

        bookDao.setManager(manager);

        bookDao.getAllBooks().forEach(System.out::println);

        context.close();
    }

    /*public static void database() {
        Author a = new Author(1L, "Lev" , "Tolstoy");
        Book b = new Book("War and Peace", 1870);
        b.setAuthor(a);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prodUnit");
        EntityManager manager = factory.createEntityManager();
        *//*manager.getTransaction().begin();
        try {
            manager.persist(a);
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
            throw e;
        }
        manager.getTransaction().commit();

        manager.getTransaction().begin();
        try {
            manager.persist(b);
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
            throw e;
        }
        manager.getTransaction().commit();*//*

        BookDao bookDao = new BookDaoImpl(manager);

        *//*bookDao.getAllBooks()
                .forEach(System.out::println);*//*

        bookDao.getAllBooksByAuthor(a)
                .forEach(System.out::println);

        manager.close();
        factory.close();
    }*/
}
