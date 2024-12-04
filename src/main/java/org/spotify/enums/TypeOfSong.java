package org.spotify.enums;

/**
 * Enum representing the different types of songs.
 * <p>
 * The {@code TypeOfSong} enum defines various categories that describe the type or version
 * of a song. These types help categorize songs based on their style, format, or the way they
 * were created or altered.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public enum TypeOfSong {

    /**
     * An original song, created and composed by the artist.
     */
    Original,

    /**
     * A remix of the original song, typically with added beats, effects, or changes in structure.
     */
    Remix,

    /**
     * A cover version of the original song, performed by a different artist.
     */
    Cover,

    /**
     * A remake of the original song, which is typically a modern or alternative version of it.
     */
    Remake,

    /**
     * A mashup of multiple songs, blended together to form a new composition.
     */
    Mashup,

    /**
     * A version of the song with the lead vocals removed, often used for karaoke or instrumental performances.
     */
    MinusOne,

    /**
     * A DJ set, often a live performance where the DJ mixes and plays several songs or remixes.
     */
    DJSet
}
