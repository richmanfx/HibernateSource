package ru.r5am.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.r5am.hibernate.entity.Author;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by zoer on 14.01.2017.
 *
 */
public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public List<Author> getAuthorList() {
        // Открыть сессию для манипуляции с персистентными объектами
        Session session = sessionFactory.openSession();
        session.get(Author.class, 1L);

        // Подготовка запроса
         // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();  // Уже deprecated
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        cq.select(root);

        // Выполнение запроса
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
    }

    public Author getAuhor(String name) {
        return null;
    }
}
