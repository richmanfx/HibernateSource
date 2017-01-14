package ru.r5am.hibernate;

import org.hibernate.Session;
import ru.r5am.hibernate.entity.Author;

/**
 * Created by zoer on 14.01.2017.
 *
 */
public class Start {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Author author:new AuthorHelper().getAuthorList()
                ) {
            System.out.println("author = " + author.getName());
        }
    }
}
