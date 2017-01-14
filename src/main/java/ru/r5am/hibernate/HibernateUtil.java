package ru.r5am.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by zoer on 14.01.2017.
 *
 */
class HibernateUtil {
    // Фабрика сессий
    private static SessionFactory sessionFactory;

    static {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder() // Получение реестра сервисов
                .configure()    // взять настройки из hibernate.cfg.xml, он попадает в classpath так как в resources
                .build();

        try {
            // MetadataSources - для работы с метаданными маппинга объектов
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Throwable e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
