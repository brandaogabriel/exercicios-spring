INSERT INTO tb_artist (name, nationality, created_at, updated_at) VALUES ('Michael Jackson','Americano', NOW(), NOW());
INSERT INTO tb_artist (name, nationality, created_at, updated_at) VALUES ('Britney Spears', 'Americano', NOW(), NOW ());

INSERT INTO tb_album (name, duration, release_date) VALUES ('Bad', 2880, TIMESTAMP WITHOUT TIME ZONE '1987-08-31T12:00:00Z');
INSERT INTO tb_album (name, duration, release_date) VALUES ('Thriller', 2520, TIMESTAMP WITHOUT TIME ZONE '1982-11-30T17:00:00Z');
INSERT INTO tb_album (name, duration, release_date) VALUES ('History: Past, Present and Future - Book 1', 8880, TIMESTAMP WITHOUT TIME ZONE '1995-06-16T20:00:00Z');

INSERT INTO tb_music (name, duration, release_date) VALUES ('They dont care about us', 240, TIMESTAMP WITHOUT TIME ZONE '1996-03-31T09:00:00Z');
INSERT INTO tb_music (name, duration, release_date) VALUES ('The Way You Make Me Feel', 310, TIMESTAMP WITHOUT TIME ZONE '1987-11-09T12:00:00Z');
INSERT INTO tb_music (name, duration, release_date) VALUES ('Bad', 250, TIMESTAMP WITHOUT TIME ZONE '1987-09-07T14:00:00Z');
INSERT INTO tb_music (name, duration, release_date) VALUES ('Billie Jean', 330, TIMESTAMP WITHOUT TIME ZONE '1983-01-02T17:00:00Z');

INSERT INTO tb_album_musics (album_id, music_id) VALUES (1, 3);
INSERT INTO tb_album_musics (album_id, music_id) VALUES (2, 4);
INSERT INTO tb_album_musics (album_id, music_id) VALUES (3, 1);
INSERT INTO tb_album_musics (album_id, music_id) VALUES (1, 2);

INSERT INTO tb_album_participants (album_id, artist_id) VALUES (1, 1);
INSERT INTO tb_album_participants (album_id, artist_id) VALUES (1, 2);
INSERT INTO tb_album_participants (album_id, artist_id) VALUES (2, 1);
INSERT INTO tb_album_participants (album_id, artist_id) VALUES (3, 1);

INSERT INTO tb_music_interpreters (music_id, artist_id) VALUES (1, 1);
INSERT INTO tb_music_interpreters (music_id, artist_id) VALUES (2, 1);
INSERT INTO tb_music_interpreters (music_id, artist_id) VALUES (3, 1);
INSERT INTO tb_music_interpreters (music_id, artist_id) VALUES (4, 1);
INSERT INTO tb_music_interpreters (music_id, artist_id) VALUES (2, 2);

INSERT INTO tb_music_authors (music_id, artist_id) VALUES (1, 1);
INSERT INTO tb_music_authors (music_id, artist_id) VALUES (2, 1);
INSERT INTO tb_music_authors (music_id, artist_id) VALUES (3, 1);
INSERT INTO tb_music_authors (music_id, artist_id) VALUES (4, 1);