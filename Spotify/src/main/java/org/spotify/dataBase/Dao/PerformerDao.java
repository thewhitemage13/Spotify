package org.spotify.dataBase.Dao;

import lombok.Cleanup;
import org.spotify.dataBase.Util.HibernateUtil;
import org.spotify.entity.Performer;
import org.spotify.interfaces.DatabaseEntry;

public class PerformerDao implements DatabaseEntry<Performer> {
    public void databaseEntry(Performer performer){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(performer);

        session.getTransaction().commit();
    }
}
