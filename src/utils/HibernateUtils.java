package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static Session getHibernateSession() {

        final SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();

        // factory = new Configuration().configure().buildSessionFactory();
        final Session session = sf.openSession();
        return session;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
