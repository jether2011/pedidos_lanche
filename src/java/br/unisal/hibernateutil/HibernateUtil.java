package br.unisal.hibernateutil;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private SessionFactory sessionFactory;
    private static HibernateUtil instance;
    private static final String DEFAULT_CONFIG = "hibernate.cfg.xml";

    public synchronized static HibernateUtil getInstance(String config) {
        if (instance == null) {
            instance = new HibernateUtil();
            try {
                Configuration configuration = new Configuration();
                configuration.configure(config);
                instance.sessionFactory = configuration.buildSessionFactory();
            } catch (HibernateException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public static HibernateUtil getInstance() {
        return getInstance(DEFAULT_CONFIG);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
