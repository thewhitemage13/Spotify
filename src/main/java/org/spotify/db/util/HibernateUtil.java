package org.spotify.db.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.Getter;

/**
 * Utility class for managing the Hibernate {@link SessionFactory}.
 * <p>
 * The {@code HibernateUtil} class provides a static method to build and access the Hibernate {@link SessionFactory}.
 * It is designed to handle the initialization of the {@link SessionFactory} and ensures that it is created only once
 * during the application's lifecycle, following the Singleton pattern. The {@code SessionFactory} is used to open
 * sessions for interacting with the database.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class HibernateUtil {

    /**
     * The {@link SessionFactory} used to open sessions for database interaction.
     * <p>
     * This field is lazily initialized and provides access to the Hibernate {@link SessionFactory} instance.
     * The {@code @Getter} annotation from Lombok automatically generates the getter method for this field.
     * </p>
     */
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Builds the {@link SessionFactory} using the Hibernate configuration.
     * <p>
     * This method loads the Hibernate configuration from the {@code hibernate.cfg.xml} file, initializes the
     * {@link SessionFactory}, and returns it. If the initialization fails, an exception is thrown.
     * </p>
     *
     * @return the {@link SessionFactory} used to open sessions for database interaction
     * @throws ExceptionInInitializerError if there is an error during the {@link SessionFactory} creation
     */
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}

