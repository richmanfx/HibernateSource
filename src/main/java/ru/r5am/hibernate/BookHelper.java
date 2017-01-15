package ru.r5am.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.r5am.hibernate.entity.Book;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by zoer on 15.01.2017.
 *
 */
public class BookHelper {

    private SessionFactory sessionFactory;

    BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    List<Book> getBookList() {
        // Открыть сессию для манипуляции с персистентными объектами
        Session session = sessionFactory.openSession();
        session.get(Book.class, 1L);

        // Подготовка запроса
        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();  // Уже deprecated
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        // Выполнение запроса
        Query query = session.createQuery(cq);
        List<Book> bookList = query.getResultList();
        session.close();
        return bookList;
    }

    public Book getBook(String name) {
        return null;
    }
}
