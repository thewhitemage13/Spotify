package org.spotify.dataBase.Dao;

import lombok.Cleanup;
import org.spotify.dataBase.Util.HibernateUtil;
import org.spotify.entity.Song;
import org.spotify.interfaces.DatabaseEntry;

public class SongDao implements DatabaseEntry<Song> {
    public void databaseEntry(Song song){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(song);

        session.getTransaction().commit();
    }
}
