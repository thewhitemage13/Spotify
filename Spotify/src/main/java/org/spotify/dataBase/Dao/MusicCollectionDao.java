package org.spotify.dataBase.Dao;

import lombok.Cleanup;
import org.spotify.dataBase.Util.HibernateUtil;
import org.spotify.entity.MusicCollection;
import org.spotify.interfaces.DatabaseEntry;

public class MusicCollectionDao implements DatabaseEntry<MusicCollection> {
    public void databaseEntry(MusicCollection musicCollection){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(musicCollection);

        session.getTransaction().commit();
    }
}
