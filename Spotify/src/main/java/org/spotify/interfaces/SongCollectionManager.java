package org.spotify.interfaces;

public interface SongCollectionManager<T> {
    public void add(T song);
    public void remove(T song);
}
