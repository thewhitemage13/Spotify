package org.spotify.dataBase.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
