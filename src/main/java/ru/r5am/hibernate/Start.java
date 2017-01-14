package ru.r5am.hibernate;

import org.hibernate.Session;

/**
 * Created by zoer on 14.01.2017.
 *
 */
public class Start {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

    }
}
