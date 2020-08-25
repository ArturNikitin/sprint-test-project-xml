package dao.impl;

import dao.BookDao;
import entity.Author;
import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookDaoImpl implements BookDao {


    private EntityManager manager;

    public BookDaoImpl() {

    }

    public BookDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Book> getAllBooks() {
        try {
            return manager.createQuery("FROM Book", Book.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> getAllBooksByAuthor(Author author) {
        try {
            return manager.createQuery("FROM Book b WHERE b.author.id = :authorID", Book.class)
                    .setParameter("authorID", author.getId())
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
