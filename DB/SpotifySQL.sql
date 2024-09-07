CREATE TABLE songs (
    song_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    song_name VARCHAR(255) NOT NULL,
    type_of_song VARCHAR(255) NOT NULL,
    duration INT NOT NULL,
    file_path VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL
);

CREATE TABLE performers (
    performer_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    performer_name VARCHAR(256) NOT NULL,
    genre VARCHAR(256) NOT NULL
);

CREATE TABLE music_collections (
    music_collection_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    music_collection_name VARCHAR(256) NOT NULL,
    type_of_collection VARCHAR(256) NOT NULL,
    release_date DATE,
    performer_id BIGINT REFERENCES performers(performer_id) NOT NULL
);

CREATE TABLE music_collection_songs (
    music_collection_id BIGINT REFERENCES music_collections(music_collection_id),
    song_id BIGINT REFERENCES songs(song_id),
    PRIMARY KEY (music_collection_id, song_id)
);

DROP TABLE music_collection_songs;
DROP TABLE music_collections;
DROP TABLE performers;
DROP TABLE songs;