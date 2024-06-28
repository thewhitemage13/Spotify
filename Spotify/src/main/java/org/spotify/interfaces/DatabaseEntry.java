package org.spotify.interfaces;

import org.spotify.entity.Performer;

public interface DatabaseEntry <T>{
    public void databaseEntry(T object);
}
